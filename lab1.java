/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lab1;

/**
 *
 * @author SHI Tingsheng (Stinson)
 */
public class NewMain {
    
    // To find the maximum of three numbers, we simply find the number that is
    // greater than or equal to both the other two numbers.
    public static int max3(int num1, int num2, int num3) {
        // num1 is greater than or equal to both num2 and num3, so num1 is maximum
        if (num1 >= num2 && num1 >= num3) return num1;
        // num2 is greater than or equal to both num1 and num3, so num2 is maximum 
        else if (num2 >= num1 && num2 >= num3) return num2;
        // num3 is greater than or equal to both num1 and num2, so num3 is maximum  
        else return num3;
    }
    
    // To find the minimum of three numbers, we simply find the number that is
    // smaller than or equal to both the other two numbers.
    public static int min3(int num1, int num2, int num3) {
        // num1 is smaller than or equal to both num2 and num3, so num1 is minimum
        if (num1 <= num2 && num1 <= num3) return num1;
        // num2 is smaller than or equal to both num1 and num3, so num2 is minimum
        else if (num2 <= num1 && num2 <= num3) return num2;
        // num3 is smaller than or equal to both num1 and num2, so num3 is minimum
        else return num3;
    }  
    
    // To find the average of three numbers, we simply compute the sum of the 
    // three numbers and divide it by 3. Note that we choose to return the result
    // in double since it is likely for a non-perfect division to occur.
    public static double avg3(int num1, int num2, int num3) {
        return (num1 + num2 + num3) / 3.0;
    }     
    
    // To find the maximum of n numbers, we iterate through all numbers, and 
    // update the variable ans with the maximum number so far.
    public static int maxn(int... args) { 
        // Throw exception when there is no input argument.
        if (args.length == 0) {
            throw new IllegalArgumentException("No input arguments.");
        }
        // Initialize answer as the first number.
        int ans = args[0];
        // Iterate through all numbers and keep the maximum number so far.
        for (int arg : args) {
            if (ans < arg) ans = arg;
        }
        return ans;
    }

    // To find the minimum of n numbers, we iterate through all numbers, and 
    // update the variable ans with the minimum number so far.
    public static int minn(int... args) { 
        // Throw exception when there is no input argument.
        if (args.length == 0) {
            throw new IllegalArgumentException("No input arguments.");
        }
        // Initialize answer as the first number.
        int ans = args[0];
        // Iterate through all numbers and keep the minimum number so far.
        for (int arg : args) {
            if (ans > arg) ans = arg;
        }
        return ans;
    }

    // To find the average of n numbers, we compute the sum of all numbers and
    // divide the result and divide it by the count of numbers. Note that we 
    // choose to return the result in double since it is likely for a non-perfect 
    // division to occur.
    public static double avgn(int... args) { 
        // Throw exception when there is no input argument.        
        if (args.length == 0) {
            throw new IllegalArgumentException("No input arguments.");
        }
        // Initialize the sum of all numbers as 0.
        int total = 0;
        // Initialize the count of numbers as 0.
        int count = 0;
        // Iterate through all numbers.
        for (int arg : args) {
            // Add current number to the sum.
            total += arg;
            // Increase the count of numbers by 1.
            count += 1;
        }
        // The average is the sum of all numbers divided by the count of numbers.
        return (double) total / count;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(max3(4,3,6)); // Expected 6, got 6.
        System.out.println(min3(4,3,6)); // Expected 3, got 3.
        System.out.println(avg3(4,3,6)); // Expected 4.333, got 4.333.
        System.out.println(maxn(4,3,6)); // Expected 6, got 6.
        System.out.println(minn(4,3,6)); // Expected 3, got 3.
        System.out.println(avgn(4,3,6)); // Expected 4.33, got 4.33.
        System.out.println(maxn(4,3,6,2)); // Expected 6, got 6.
        System.out.println(minn(4)); // Expected 4, got 4.
        System.out.println(avgn(4,3,6,1,2,3)); // Expected 3.167, got 3.167.
    }
}

