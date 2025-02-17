import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read number of squares in the chocolate bar
        int n = scanner.nextInt();
        int[] s = new int[n];
        
        // Read the numbers on each of the squares
        for (int i = 0; i < n; i++) {
            s[i] = scanner.nextInt();
        }
        
        // Read Ron's birth day and birth month
        int d = scanner.nextInt(); // birth day
        int m = scanner.nextInt(); // birth month
        
        // Compute and print the number of ways Lily can share the chocolate bar
        int result = birthday(s, d, m);
        System.out.println(result);
        
        scanner.close();
    }
    
    public static int birthday(int[] s, int d, int m) {
        int count = 0;
        
        // Loop through the array and check each contiguous segment of length m
        for (int i = 0; i <= s.length - m; i++) {
            int sum = 0;
            // Sum the segment starting at index i of length m
            for (int j = 0; j < m; j++) {
                sum += s[i + j];
            }
            // If the sum equals d, increase count
            if (sum == d) {
                count++;
            }
        }
        
        return count;
    }
}
