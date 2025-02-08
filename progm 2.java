import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.util.Scanner;

public class Solution {

    public static void plusMinus(int[] arr) {
        // Initialize counts for positive, negative, and zero values
        int positive = 0;
        int negative = 0;
        int zero = 0;
        
        // Count occurrences of positive, negative, and zero elements
        for (int num : arr) {
            if (num > 0) {
                positive++;
            } else if (num < 0) {
                negative++;
            } else {
                zero++;
            }
        }
        
        // Calculate and print the ratios with six decimal places
        int n = arr.length;
        System.out.printf("%.6f\n", (double) positive / n);
        System.out.printf("%.6f\n", (double) negative / n);
        System.out.printf("%.6f\n", (double) zero / n);
    }

    public static void main(String[] args) {
        // Read input from the user
        Scanner scanner = new Scanner(System.in);
        
        // Size of the array
        int n = scanner.nextInt();
        
        // Array of integers
        int[] arr = new int[n];
        
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        
        // Call the plusMinus function
        plusMinus(arr);
        
        // Close the scanner
        scanner.close();
    }
}
