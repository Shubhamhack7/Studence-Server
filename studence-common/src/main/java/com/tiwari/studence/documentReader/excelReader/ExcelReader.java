package com.tiwari.studence.documentReader.excelReader;

import com.tiwari.studence.proto.fileInfo.Extension;
import com.tiwari.studence.util.exception.LoggedRuntimeException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class ExcelReader {

  public void workbookObject(String path, Extension extension) {

  }

  public void workbookObject(byte[] content) {
    try (ByteArrayInputStream inputStream = new ByteArrayInputStream(content)) {
      Workbook workbook = new XSSFWorkbook(inputStream);
      Sheet sheet = workbook.getSheetAt(0); // Get the first sheet

      // Iterate through rows and cells
      for (Row row : sheet) {
        for (Cell cell : row) {
          switch (cell.getCellType()) {
          case STRING:
            System.out.println(cell.getStringCellValue());
            break;
          case NUMERIC:
            System.out.println(cell.getNumericCellValue());
            break;
          case BOOLEAN:
            System.out.println(cell.getBooleanCellValue());
            break;
          // Handle other cell types (formula, date, etc.) if needed
          }
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
      //throw new LoggedRuntimeException();
    }
  }
}
