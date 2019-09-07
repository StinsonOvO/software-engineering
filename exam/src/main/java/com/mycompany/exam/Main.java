
package com.mycompany.exam;

/**
 * @version $Revision: 1.1.1.1 $
 * @since Build 1.1.1.1 (2019)
 * @author SHI Tingsheng (Stinson)
 * @date 4 Sep 2019
 */

/**
 * Project Description
 * This project aims to create a series of objects that can be reused to store a student examination.
 * I picked 3 types of questions: multiple choice questions (MCQ), arithmetic questions (Arithmetic),
 * and short answer questions (Short_Answer). I picked these 3 types of questions since the solution
 * to each of them has different data types, i.e., character for MCQ, integer for Arithmetic, and
 * string for Short_Answer. I would like to include have a fixed solution for each question so that
 * I am able to check whether the user's answer is correct or not; for this reason, I did not include
 * open questions as they are difficult to grade. 
 * 
 * In order to explore some different file format to store the questions in order to make the exam
 * reproducible, I have chosen JSON so that I can get some practice other than XML which we did in 
 * class for many times. It turns out the process of reading and writing files with JSON is very 
 * similar to that of XML. In both cases, we will need to import the specific parser and deal with
 * the I/O exceptions.
**/


public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        /**
         * Main.java
         * You are able to create a test, simply by specifying the path of the json 
         * file that contains the questions. I have created three exams with easy,
         * medium, and hard difficulty, with names
         * easy.json, medium.json, and hard.json, respectively.
         * Please feel free to challenge yourself and do all of them!!
         **/
        
        Test t = new Test("easy.json"); // easy.json || medium.json || hard.json
        
        // Call the method test on a Test object to start the exam.
        t.test(); 
    }
}
