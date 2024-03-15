package com.tiwari.studence.server;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.*;
import com.google.inject.Injector;
import com.tiwari.studence.campus.service.ICampusService;
import com.tiwari.studence.common.schduler.StudenceSchduler;
import com.tiwari.studence.organisation.service.IOrganisationService;
import com.tiwari.studence.proto.campus.CampusPb;
import com.tiwari.studence.proto.campus.OrganisationCreateAndCampusCreateReqPb;
import com.tiwari.studence.proto.contactDetails.*;
import com.tiwari.studence.proto.login.LoginPb;
import com.tiwari.studence.proto.login.ProfileTypeEnum;
import com.tiwari.studence.proto.name.NamePb;
import com.tiwari.studence.proto.organisation.OrganisationPb;
import com.tiwari.studence.server.createLogin.service.ICreateLoginService;
import com.tiwari.studence.server.organisationCreateAndCampus.service.IOrganisationCreateAndCampusCreate;
import com.tiwari.studence.server.organisationCreateAndCampus.service.OrganisationCreateAndCampusCreateService;
import com.tiwari.studence.util.exception.ErrorException;
import com.tiwari.studence.util.protobuf.ProtobufToJson;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.SchedulerException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class StudenceServerTest {
  public static void main(String[] args) throws ErrorException, IOException, SchedulerException {
    //Injector inj = InjectorProvider.createInjector();
    // createLogin(inj);
    //createTestOrgCampus(inj);
    //FirebaseInitializer.init();
    //eventFirestore();
    //schdulerTest();
    findTargetFolder("/home/tiwaritiwari/Studence/Studence-Server","target");
  }

  public static void findTargetFolder(String initialPath, String targetFolderName)
          throws IOException {
    File dir = new File(initialPath);
    if (dir.exists() && dir.isDirectory()) {
      for (File file : dir.listFiles()) {
        if (file.isDirectory() && !file.getName().equals(targetFolderName)) {
          findTargetFolder(file.getAbsolutePath(), targetFolderName); // Recursively explore subdirectories
        } else if (file.getName().equals(targetFolderName)) {
          System.out.println("Target folder found: " + file.getAbsolutePath());
          deleteFolder(file,targetFolderName);
        }
      }
    } else {
      System.out.println("Invalid initial path: " + initialPath);
    }
  }

  private static void deleteFolder(File folder, String targetFolderName) throws IOException {
    if (folder.isDirectory()) {
      for (File file : folder.listFiles()) {
        deleteFolder(file, targetFolderName); // Recursively delete contents
      }
      if (folder.isDirectory() && !folder.getName().equals(targetFolderName)) {
        folder.delete();
        System.out.println("Deleted: " + folder.getAbsolutePath());
      }
    } else {
      if (folder.isDirectory() && !folder.getName().equals(targetFolderName)) {
        folder.delete();
        System.out.println("Deleted: " + folder.getAbsolutePath());
      }

    }
  }


  private static void schdulerTest() throws SchedulerException {
    StudenceSchduler schduler = new StudenceSchduler();
   // schduler.scheduleTask("Task1", TimeType.INTERVAL, IntervalType.MINUTE, "", IntervalJob.class);

  }

  private static void eventFirestore() throws IOException {
    FileInputStream serviceAccount = new FileInputStream(
            "/home/tiwaritiwari/Studence/ConfigJSON/studence-dev-firebase-adminsdk-hdb11-fb9c7dc05a.json");
    StorageOptions storageOp = StorageOptions.newBuilder()
            .setCredentials(GoogleCredentials.fromStream(serviceAccount))
            .setProjectId("studence-dev").build();
    Storage storage = storageOp.getService();
    // Create bucket (replace with your desired options)
    Bucket bucket = storage.create(BucketInfo.of("studence-dev.appspot.com"));

    // Simulate folder creation by using prefixes in object keys
    String folder1 = "DEVELOPMENT/DUMP/STUDENT/IN";
    BlobId blobId = BlobId.of(bucket.getName(), "important_doc.txt");
    BlobInfo blobInfo = BlobInfo.newBuilder(blobId).build();
    // Upload files with folder paths in their names
    storage.create(blobInfo, folder1.getBytes(),
            Storage.BlobTargetOption.predefinedAcl(Storage.PredefinedAcl.PUBLIC_READ));

    System.out.printf("Files uploaded to simulated folders: %s and %s\n", folder1);
  }

  private static void createTestOrgCampus(Injector inj) throws ErrorException {
    IOrganisationCreateAndCampusCreate a = inj.getInstance(
            OrganisationCreateAndCampusCreateService.class);
    OrganisationPb.Builder orgBuilder = OrganisationPb.newBuilder();

    // Create the NamePb for Organisation
    NamePb orgName = NamePb.newBuilder().setFirstName("Test").setLastName("Public School").build();

    // Create the ContactDetailsPb for Organisation
    ContactDetailsPb orgContactDetails = ContactDetailsPb.newBuilder()
            .build(); // You can set MobileNumbers, Emails, and Addresses as needed

    MobileNumberPb primaryMobile = MobileNumberPb.newBuilder().setCode(ISDCode.ISD_ONE)
            .setNumber("1234567890").build();

    MobileNumberPb mobile1 = MobileNumberPb.newBuilder().setCode(ISDCode.ISD_TWENTY)
            .setNumber("9876543210").build();

    MobileNumbersPb mobileNumbers = MobileNumbersPb.newBuilder().setPrimary(primaryMobile)
            .addOthers(mobile1).build();

    // Create EmailsPb
    EmailPb primaryEmail = EmailPb.newBuilder().setLocalPart("test").setDomainPart("studence.com")
            .build();

    EmailsPb emails = EmailsPb.newBuilder().setPrimary(primaryEmail).build();

    // Create AddressesPb
    AddressPb primaryAddress = AddressPb.newBuilder().setStreet("123 Main St").setArea("Downtown")
            .setCity("New York").setPincode("10001")
            .setState(CountryStateEnum.ARUNACHAL_PRADESH.name()).setCountry("USA").build();

    AddressPb address1 = AddressPb.newBuilder().setStreet("456 Elm St").setArea("Suburb")
            .setCity("San Francisco").setPincode("94101")
            .setState(CountryStateEnum.ARUNACHAL_PRADESH.name()).setCountry("USA")
            .setCanonicalAddress("456 Elm St, Suburb, San Francisco, 94101, USA").build();

    AddressesPb addresses = AddressesPb.newBuilder().setPrimary(primaryAddress).build();

    // Create ContactDetailsPb
    ContactDetailsPb contactDetails = ContactDetailsPb.newBuilder().setMobileNumbers(mobileNumbers)
            .setEmails(emails).setAddress(addresses).build();

    // Set the components for the OrganisationPb
    orgBuilder.setName(orgName);
    orgBuilder.setContactDetails(contactDetails);

    OrganisationPb organisation = orgBuilder.build();

    // Create a new CampusPb.Builder
    CampusPb.Builder campusBuilder = CampusPb.newBuilder();

    // Create the NamePb for Campus
    NamePb campusName = NamePb.newBuilder().setFirstName("A-Test").setLastName("Public School")
            .build();

    // Create the ContactDetailsPb for Campus
    ContactDetailsPb campusContactDetails = ContactDetailsPb.newBuilder()
            .build(); // You can set MobileNumbers, Emails, and Addresses as needed

    EmailPb primaryEmail2 = EmailPb.newBuilder().setLocalPart("a.test")
            .setDomainPart("studence.com").build();

    EmailsPb emails2 = EmailsPb.newBuilder().setPrimary(primaryEmail2).build();

    ContactDetailsPb contactDetails2 = ContactDetailsPb.newBuilder().setMobileNumbers(mobileNumbers)
            .setEmails(emails2).setAddress(addresses).build();

    // Set the components for the CampusPb
    campusBuilder.setName(campusName);
    campusBuilder.setContactDetails(contactDetails2);

    CampusPb campus = campusBuilder.build();

    // Create the OrganisationCreateAndCampusCreateReqPb using the Organisation and Campus
    OrganisationCreateAndCampusCreateReqPb.Builder requestBuilder = OrganisationCreateAndCampusCreateReqPb.newBuilder();
    requestBuilder.setOrganisation(organisation);
    requestBuilder.setCampus(campus);

    OrganisationCreateAndCampusCreateReqPb request = requestBuilder.build();
    System.out.println(ProtobufToJson.protobufToJsonString(a.executeService(request).get()));

  }

  private static void createLogin(Injector inj) throws ErrorException {
    ICreateLoginService a = inj.getInstance(ICreateLoginService.class);
    IOrganisationService org = inj.getInstance(IOrganisationService.class);
    ICampusService campus = inj.getInstance(ICampusService.class);
    CampusPb orgPb = campus.get("XA!1472").get();
    LoginPb.Builder builder = LoginPb.newBuilder();
    builder.setType(ProfileTypeEnum.ADMIN);
    builder.getEmailIdBuilder().setLocalPart("dev.admin");
    builder.getEmailIdBuilder().setDomainPart("studence.com");
    builder.getMobileNoBuilder().setCode(ISDCode.ISD_NINETY_ONE);
    builder.getMobileNoBuilder().setNumber("9621019232");
   /* builder.getRefBuilder().setDbInfoId(
            EntityUtilHelper.getDbInfoIdWithSpecialCharecterUsingEntityPb(orgPb.getDbInfo()));
    builder.getRefBuilder().setName(orgPb.getName().getCanonicalName());*/
    builder.setEncryptedPassword("admin@123");
    System.out.println(a.executeService(builder.build()).get());
  }

  public static class IntervalJob implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
      String taskName = (String) context.getJobDetail().getJobDataMap().get("taskName");
      System.out.println("Executing interval task: " + taskName);
    }
  }

}


