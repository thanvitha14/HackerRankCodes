import java.util.Scanner;

public class Solution {

    public static void separateNumbers(String s) {
        int n = s.length();
        
        // Try every possible length for the first number
        for (int i = 1; i <= n / 2; i++) {
            // Start by taking the first number of length i
            String firstNum = s.substring(0, i);
            
            // Check if the number has leading zeros
            if (firstNum.length() > 1 && firstNum.charAt(0) == '0') {
                continue;  // Skip this choice if the first number has leading zeros
            }
            
            // Try to form the sequence with the current first number
            long num = Long.parseLong(firstNum);
            StringBuilder sequence = new StringBuilder(firstNum);
            
            // Now, try to form the rest of the sequence
            boolean isBeautiful = true;
            String remainingString = s.substring(i);
            while (remainingString.length() > 0) {
                num++;
                String nextNumStr = Long.toString(num);
                
                // Check if the next number matches the start of the remaining string
                if (remainingString.startsWith(nextNumStr)) {
                    sequence.append(nextNumStr);
                    remainingString = remainingString.substring(nextNumStr.length());
                } else {
                    isBeautiful = false;
                    break;
                }
            }
            
            // If we successfully created the sequence, print the result
            if (isBeautiful && remainingString.isEmpty()) {
                System.out.println("YES " + firstNum);
                return;
            }
        }
        
        // If no valid sequence was found, print NO
        System.out.println("NO");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read number of queries
        int t = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        
        // Process each query
        for (int i = 0; i < t; i++) {
            String s = scanner.nextLine();
            separateNumbers(s);
        }
        
        scanner.close();
    }
}
