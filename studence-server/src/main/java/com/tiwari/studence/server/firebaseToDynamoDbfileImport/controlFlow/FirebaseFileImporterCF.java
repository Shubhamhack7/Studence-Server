package com.tiwari.studence.server.firebaseToDynamoDbfileImport.controlFlow;

import com.google.cloud.storage.Blob;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.Storage;
import com.tiwari.studence.common.async.AControlFlow;
import com.tiwari.studence.firebase.initializer.FirebaseInitializer;
import com.tiwari.studence.util.common.Strings;
import com.tiwari.studence.util.collect.Lists;
import com.tiwari.studence.util.collect.Pair;
import com.tiwari.studence.util.enumeration.DumpFileType;
import com.tiwari.studence.util.exception.ErrorException;
import com.tiwari.studence.util.log.DebugLogger;
import com.tiwari.studence.util.serverConfig.IServerListener;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FirebaseFileImporterCF
        extends AControlFlow<FirebaseFileImporterCF.State, String, ErrorException> {

  private IServerListener m_ServerListener;
  private final String BUCKET_NAME = "studence-dev.appspot.com";
  private Bucket bucket;
  private String prefix;

  private Map<Blob, byte[]> m_filesWithBLob = new HashMap<Blob, byte[]>();

  private List<Pair<DumpFileType, Pair<Blob, byte[]>>> m_fileWithType = Lists.newArrayList();

  int counter = 0;

  enum State {
    FILE_CHECKER,
    FILE_ANALYSER,
    PROCESS,
    STUDENT_IMPORTER,
    TEACHER_IMPORTER,
    MOVE_FILE,
    DONE,
  }

  public FirebaseFileImporterCF(IServerListener serverListener) {
    super(State.FILE_CHECKER, State.DONE);
    m_ServerListener = serverListener;
    counter = 0;
    addStateHandler(State.FILE_CHECKER, new FileCheckerState());
    addStateHandler(State.FILE_ANALYSER, new FileAnalyserState());
    addStateHandler(State.PROCESS, new ProcessState());
    addStateHandler(State.STUDENT_IMPORTER, new StudentImporterState());
  }

  public class FileCheckerState implements StateHandler<State> {

    @Override
    public void registerCalls() {

    }

    @Override
    public State handleState() {
      bucket = FirebaseInitializer.getFirebaseStorageClient().bucket(BUCKET_NAME);
      prefix = Strings.appendSlash(m_ServerListener.getEnvironmentType().name());
      for (Blob blob : bucket.getStorage().list(BUCKET_NAME, Storage.BlobListOption.prefix(prefix))
              .iterateAll()) {
        Blob blobfile = bucket.getStorage().get(blob.getBlobId());
        if (blobfile.getSize() > 0 && blobfile.getContentType()
                .equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
          DebugLogger.info(blobfile.getName());
          m_filesWithBLob.put(blobfile,
                  bucket.getStorage().readAllBytes(BUCKET_NAME, blobfile.getName()));
        }
      }
      return State.FILE_ANALYSER;
      //getAsyncCallback().handleUnexpectedException(new LoggedRuntimeException(e));
    }

  }

  public class FileAnalyserState implements StateHandler<State> {

    @Override
    public void registerCalls() {

    }

    @Override
    public State handleState() {
      m_filesWithBLob.forEach((key, value) -> {
        if (key.getName().contains(DumpFileType.STUDENT.name())) {
          m_fileWithType.add(new Pair<DumpFileType, Pair<Blob, byte[]>>(DumpFileType.STUDENT,
                  new Pair<Blob, byte[]>(key, value)));
        } else if (key.getName().contains(DumpFileType.TEACHER.name())) {
          m_fileWithType.add(new Pair<DumpFileType, Pair<Blob, byte[]>>(DumpFileType.TEACHER,
                  new Pair<Blob, byte[]>(key, value)));
        } else {
          //nothing
        }
      });
      return State.PROCESS;
      //getAsyncCallback().handleUnexpectedException(new LoggedRuntimeException(e));
    }

  }

  public class ProcessState implements StateHandler<State> {

    @Override
    public void registerCalls() {

    }

    @Override
    public State handleState() {
      if (m_fileWithType.size() > 0) {
        for (int i = counter; i < m_fileWithType.size(); counter++) {
          if (m_fileWithType.get(counter).getFirst() == DumpFileType.STUDENT) {
            return State.STUDENT_IMPORTER;
          } else if (m_fileWithType.get(counter).getFirst() == DumpFileType.TEACHER) {
            return State.TEACHER_IMPORTER;
          } else {
            //nothing
          }
        }
        return State.MOVE_FILE;
      }
      return State.DONE;
      //getAsyncCallback().handleUnexpectedException(new LoggedRuntimeException(e));
    }

  }

  public class StudentImporterState implements StateHandler<State> {

    @Override
    public void registerCalls() {
      Pair<DumpFileType, Pair<Blob, byte[]>> dataObj  = m_fileWithType.get(counter);

    }

    @Override
    public State handleState() {
      if (m_fileWithType.size() > 0) {
        for (int i = counter; i < m_fileWithType.size(); counter++) {
          if (m_fileWithType.get(counter).getFirst() == DumpFileType.STUDENT) {
            return State.STUDENT_IMPORTER;
          } else if (m_fileWithType.get(counter).getFirst() == DumpFileType.TEACHER) {
            return State.TEACHER_IMPORTER;
          } else {
            //nothing
          }
        }
        return State.MOVE_FILE;
      }
      return State.DONE;
      //getAsyncCallback().handleUnexpectedException(new LoggedRuntimeException(e));
    }

  }

}

