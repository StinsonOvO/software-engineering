package com.mycompany.exam;

/**
 *
 * @author SHI Tingsheng (Stinson) <tingsheng.shi@u.yale-nus.edu.sg>
 * 
 * Question.java
 * This files contains the three classes of questions, i.e.,
 * multiple choice questions (MCQ), arithmetic questions (Arithmetic),
 * and short answer questions (Short_Answer). Each question contains
 * methods deliver, message, and check, which are explained below.
 * 
 */

public class Question {

    String question;

    // displays the question
    public void deliver() {
        System.out.println();
        System.out.println(question);
    }
}

// For an MCQ, the solution is represented by a char.
class MCQ extends Question {

    char solution;

    MCQ(String question, char solution) {
        this.question = question;
        this.solution = solution;
    }

    // instruction of how to enter the answer
    public void message() {
        System.out.println("(Hint: Please enter a single lower-case letter.)");
    }

    // check correctness of user's answer
    public void check(String ans) {
        System.out.println();
        try {
            if (ans.charAt(0) == solution) {
                System.out.println("Well done! Your answer is correct.");
            } else {
                System.out.println("Oops! Your answer is incorrect. The correct answer is "
                        + String.valueOf(solution) + ".");
            }
        } catch (java.lang.StringIndexOutOfBoundsException ex) {
            System.out.println("You did not provide an answer. The correct answer is "
                    + String.valueOf(solution) + ".");
        }
    }
}


// For an arithmetic question, the solution is represented by an int.
class Arithmetic extends Question {

    int solution;

    Arithmetic(String question, int solution) {
        this.question = question;
        this.solution = solution;
    }

    // instruction of how to enter the answer
    public void message() {
        System.out.println("(Hint: Please enter a number without trailing punctuation.)");
    }
    
    // check correctness of user's answer
    public void check(String ans) {
        System.out.println();
        try {
            if (Integer.valueOf(ans) == solution) {
                System.out.println("Well done! Your answer is correct.");
            } else {
                System.out.println("Oops! Your answer is incorrect. The correct answer is "
                        + String.valueOf(solution) + ".");
            }
        } catch (java.lang.NumberFormatException ex) {
            System.out.println("Your input format is incorrect. The correct answer is "
                    + String.valueOf(solution) + ".");
        }
    }
}


// For a Short_Answer question, the solution is represented by a String.
class Short_Answer extends Question {

    String solution;

    Short_Answer(String question, String solution) {
        this.question = question;
        this.solution = solution;
    }

    // instruction of how to enter the answer
    public void message() {
        System.out.println("(Hint: Please enter a word or two without trailing punctuation. "
                + "Case Insensitive.)" + ".");
    }
    
    // check correctness of user's answer
    public void check(String ans) {
        System.out.println();
        if (ans.toLowerCase().equals(solution.toLowerCase())) {
            System.out.println("Well done! Your answer is correct.");
        } else {
            System.out.println("Oops! Your answer is incorrect. The correct answer is "
                    + String.valueOf(solution) + ".");
        }
    }
}
