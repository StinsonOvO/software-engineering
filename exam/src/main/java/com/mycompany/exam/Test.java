package com.mycompany.exam;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.BufferedReader; 
import java.io.InputStreamReader; 

/**
 *
 * @author SHI Tingsheng (Stinson) <tingsheng.shi@u.yale-nus.edu.sg>
 * 
 * Test.java
 * This files defines the procedure of an exam.
 * 
 */
public class Test {
    
    // file pointer to the JSON file that contains the exam
    String fp;
    
    Test(String fp) {
        this.fp = fp;
    }
    
    public void test() {
        
       // reading the JSON file
        FileReader reader = null;
        try {
            JSONParser jsonParser = new JSONParser();
            reader = new FileReader(fp);
            Object obj = null;
            try {
                obj = jsonParser.parse(reader);
            } catch (IOException | ParseException ex) {
                Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
            }
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray qs = (JSONArray) jsonObject.get("questions");
           
            // start of the exam & announcement of number of questions.
            System.out.println("The exam starts now. There are "
                    + qs.size() + " questions in this exam.");           
            
            // give out each question in sequence
            for (int i = 0; i < qs.size(); i++) {
                JSONObject o = (JSONObject) qs.get(i);
                
                // check question type, then deliver each question and shows the
                // hint for input format; after user enters the answer, check
                // whether user's answer matches the intended solution, and inform
                // user about the result. if user's answer is incorrect, show
                // correct answer.                            
                if (o.get("type").equals((Object) "MCQ")) {
                    MCQ q1 = new MCQ(o.get("question").toString(),
                            o.get("answer").toString().charAt(0));
                    q1.deliver();
                    q1.message();
                    BufferedReader bufferreader = new BufferedReader(new InputStreamReader(System.in)); 
                    String ans = bufferreader.readLine(); 
                    q1.check(ans.trim());           
                } else if (o.get("type").equals((Object) "Arithmetic")) {
                    Arithmetic q2 = new Arithmetic(o.get("question").toString(),
                            Integer.valueOf(o.get("answer").toString()));
                    q2.deliver();
                    q2.message();
                    BufferedReader bufferreader = new BufferedReader(new InputStreamReader(System.in)); 
                    String ans = bufferreader.readLine(); 
                    q2.check(ans.trim());
                } else if (o.get("type").equals((Object) "Short_Answer")) {
                    Short_Answer q3 = new Short_Answer(o.get("question").toString(),
                            o.get("answer").toString());
                    q3.deliver();
                    q3.message();
                    BufferedReader bufferreader = new BufferedReader(new InputStreamReader(System.in)); 
                    String ans = bufferreader.readLine(); 
                    q3.check(ans.trim());
                } else {
                    System.out.println(o.get("type").toString());
                    System.out.println("This question is skipped since "
                            + "the question type is not currently supported.");
                }
            }
            
            // end of exam
            System.out.println("\nEnd of exam.");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                reader.close();
            } catch (IOException ex) {
                Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
