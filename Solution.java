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

public class Solution {

    public static void miniMaxSum(int[] arr) {
        Arrays.sort(arr);  // Sort the array to easily access the smallest and largest elements
        long minSum = 0;
        long maxSum = 0;

        // Calculate the minimum sum (sum of the first four elements)
        for (int i = 0; i < 4; i++) {
            minSum += arr[i];
        }

        // Calculate the maximum sum (sum of the last four elements)
        for (int i = 1; i < 5; i++) {
            maxSum += arr[i];
        }

        // Print the result as two space-separated long integers
        System.out.println(minSum + " " + maxSum);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Read the five integers
        int[] arr = new int[5];
        for (int i = 0; i < 5; i++) {
            arr[i] = sc.nextInt();
        }
        
        // Call the function to calculate and print the miniMaxSum
        miniMaxSum(arr);
        
        sc.close();
     }
}
