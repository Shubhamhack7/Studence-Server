package com.tiwari.studence.dump.custom;

import com.google.inject.Injector;
import com.google.protobuf.GeneratedMessageV3;
import com.tiwari.studence.dump.Injector.InjectorProvider;
import com.tiwari.studence.dump.organisation.CreateOrgAndCampusFromDump;
import com.tiwari.studence.organisation.service.IOrganisationService;
import com.tiwari.studence.proto.organisation.OrganisationSearchReqPb;
import com.tiwari.studence.util.exception.ErrorException;
import com.tiwari.studence.util.protobuf.ProtobufToJson;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FilterOrganisation {
  public static void main(String[] args) throws ErrorException, IOException {
    Injector inrjector = InjectorProvider.createInjector();
    CreateOrgAndCampusFromDump service = inrjector.getInstance(CreateOrgAndCampusFromDump.class);
    IOrganisationService orgService = inrjector.getInstance(IOrganisationService.class);
    OrganisationSearchReqPb.Builder builder = OrganisationSearchReqPb.newBuilder();
    builder.setName("515 army base wkshop high school".toLowerCase());
   // System.out.println(ProtobufToJson.protobufToJsonString(orgService.search(builder.build()).get()));
    String inputCsvFilePath = "D:\\Studence\\Studence-Server\\studence-dump\\src\\main\\resources\\CBSEschoolslist.csv";
    String outputCsvFilePath = "D:\\Studence\\Studence-Server\\studence-dump\\src\\main\\resources\\CBSE schools list1.csv";


      Map<String, Map<String, String>> groupedRows = groupRowsByInstituteName(inputCsvFilePath,service);
      //addOrganisationNameColumnAndSave(outputCsvFilePath, groupedRows);

  }

  public static Map<String, Map<String, String>> groupRowsByInstituteName(String csvFilePath,
          CreateOrgAndCampusFromDump service)
          throws IOException {
    Map<String, Map<String, String>> groupedRows = new HashMap<>();

    CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader().withIgnoreHeaderCase().withTrim();
    try (CSVParser csvParser = new CSVParser(new FileReader(csvFilePath), csvFormat)) {
      for (CSVRecord record : csvParser) {
        service.createOrgAndCampusFromDump(record);
      }
    }

    return groupedRows;
  }

  public static void addOrganisationNameColumnAndSave(String outputCsvFilePath,
          Map<String, Map<String, String>> groupedRows) throws IOException {
    CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader().withIgnoreHeaderCase().withTrim();
    try (CSVPrinter csvPrinter = new CSVPrinter(new FileWriter(outputCsvFilePath), csvFormat)) {
      csvPrinter.printRecord("Sl No", "InstituteName", "InstituteAddress",
              "InstituteCode", "School Type", "PhoneNumber", "OrganisationName");

      for (Map.Entry<String, Map<String, String>> entry : groupedRows.entrySet()) {
        String instituteName = entry.getKey();
        Map<String, String> rowMap = entry.getValue();

        for (Map.Entry<String, String> rowEntry : rowMap.entrySet()) {
          String columnName = rowEntry.getKey();
          String columnValue = rowEntry.getValue();

          if (columnName.equals("InstituteName")) {
            columnValue = instituteName;
          }
          csvPrinter.print(columnValue);
        }
        csvPrinter.println();
      }
    }
  }
}
