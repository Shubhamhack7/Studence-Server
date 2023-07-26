package com.tiwari.studence.util.time;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeUtil {

  public static String getCurrenTimeInyyyyMMddHHmmssSSS(){
    LocalDateTime now = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");
    return now.format(formatter);

  }

}
