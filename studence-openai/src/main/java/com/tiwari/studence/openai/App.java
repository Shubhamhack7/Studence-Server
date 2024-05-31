package com.tiwari.studence.openai;

import com.tiwari.studence.openai.service.GoogleGeminiService;
import com.tiwari.studence.openai.service.OpenaiService;

import java.io.IOException;

public class App {
  public static void main(String[] args) throws IOException {
    //OpenaiService.testOpenAi();
    GoogleGeminiService service = new GoogleGeminiService();
    service.buidWithGoogleGemini("can you build timetable of school classes if i provide you time,subject,an no of teacher  ? process you output in HTML page in table tag ");
  }
}

/****
 * attempt 1 - Act as a School Management authority member and build  a timetable from  classes 1 to 5 . Classes will start 7:00 am till 2:00 pm having 5 teacher ram,shyam,gopal,manish,rahul with respecticive subjects are science,maths,art,computer,english,hindi distribute every class in equal time  and after three class contains 40 mins of lunch break .Class 1 to 8 are seprate classes so if one teacher is attending a class he cant attend the different class at same time.  process your output in HTML page in table tag.
 * attempt 2 - Act as a School Management authority member and build  a timetable from  classes 1 to 5 . Classes will start 7:00 am till 2:00 pm having 5 teacher with their subjects  ram - science,shyam-maths,gopal-art,manish-computer,rahul-english distribute every class in equal time  and after three class contains 40 mins of lunch break .Class 1 to 8 are seprate classes so if one teacher is attending a class he cant attend the different class at same time.All classes start at same time from 7:00 am to 2:00 pm.  process your output in HTML page in table tag.
 * attempt 3 - You are a School Management Authority member responsible for creating a timetable for classes 1 to 5. The school operates from 7:00 am to 2:00 pm. There are five teachers with their respective subjects:

 Ram teaches Science
 Shyam teaches Maths
 Gopal teaches Art
 Manish teaches Computer
 Rahul teaches English
 Here are the requirements:

 All classes (1 to 5) should study every subject (Science, Maths, Art, Computer, English).
 Each teacher should be assigned to a specific subject.
 Classes start at the same time (7:00 am) and end at the same time (2:00 pm).
 There should be a 40-minute lunch break after every three classes.
 No teacher should attend different classes simultaneously.
 Please provide a timetable that adheres to these guidelines. Feel free to adjust the timing or subjects based on your preferences, and ensure that each class covers all subjects.

 Do's and Don'ts:

 Do: Assign each teacher to a specific subject.
 Do: Ensure each class studies every subject.
 Do: Include a 40-minute lunch break after every three classes.
 Don't: Allow teachers to attend different classes simultaneously.
 Don't: Create overlapping schedules for teachers or subjects.
 ***/