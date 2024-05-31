package com.tiwari.studence.server.firebaseToDynamoDbfileImport.controlFlow;

import com.tiwari.studence.common.async.IFuture;
import com.tiwari.studence.util.exception.ErrorException;
import com.tiwari.studence.util.serverConfig.IServerListener;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class FirebaseFileImporter {

  private IServerListener m_ServerListener;

  @Inject
  public FirebaseFileImporter(IServerListener serverListener) {
    m_ServerListener = serverListener;
  }

  public IFuture<String, ErrorException> importFile() {
    FirebaseFileImporterCF cf = new FirebaseFileImporterCF(m_ServerListener);
    cf.addLogObjects();
    cf.startAsyncCall();
    return cf.getFutureResult();
  }

}
