package com.tiwari.studence.campus;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        LocalDateTime now = LocalDateTime.now();

        // Define the desired date-time format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");

        // Format the current date and time according to the defined format
        String formattedDateTime = now.format(formatter);

        // Print the formatted date and time
        System.out.println("Formatted Date-Time: " + formattedDateTime);
        System.out.println( "Hello World!" );
    }
}
