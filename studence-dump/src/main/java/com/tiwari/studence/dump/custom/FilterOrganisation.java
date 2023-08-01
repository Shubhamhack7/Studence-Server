package com.tiwari.studence.dump.custom;

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
  public static void main(String[] args) {
    String inputCsvFilePath = "D:\\Studence\\Studence-Server\\studence-dump\\src\\main\\resources\\CBSEschoolslist.csv";
    String outputCsvFilePath = "D:\\Studence\\Studence-Server\\studence-dump\\src\\main\\resources\\CBSE schools list1.csv";

    try {
      Map<String, Map<String, String>> groupedRows = groupRowsByInstituteName(inputCsvFilePath);
      addOrganisationNameColumnAndSave(outputCsvFilePath, groupedRows);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static Map<String, Map<String, String>> groupRowsByInstituteName(String csvFilePath)
          throws IOException {
    Map<String, Map<String, String>> groupedRows = new HashMap<>();

    CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader().withIgnoreHeaderCase().withTrim();
    try (CSVParser csvParser = new CSVParser(new FileReader(csvFilePath), csvFormat)) {
      for (CSVRecord record : csvParser) {
        System.out.println(record.get(0));
        System.out.println(record.get(1));
        System.out.println(record.get(3));
        System.out.println(record.get(4));
        System.out.println(record.get(5));
        System.out.println(record.get(6));

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
