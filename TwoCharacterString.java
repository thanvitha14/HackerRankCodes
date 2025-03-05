import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TwoCharacterString {
    
    // Function to check if the string alternates properly
    private static boolean isAlternating(String str) {
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i - 1)) {
                return false; // Consecutive characters should not be the same
            }
        }
        return true;
    }

    public static int alternate(String s) {
        Set<Character> uniqueChars = new HashSet<>();
        
        // Step 1: Extract all unique characters
        for (char c : s.toCharArray()) {
            uniqueChars.add(c);
        }

        Character[] chars = uniqueChars.toArray(new Character[0]);
        int maxLength = 0;

        // Step 2: Generate all possible pairs of characters
        for (int i = 0; i < chars.length; i++) {
            for (int j = i + 1; j < chars.length; j++) {
                char first = chars[i];
                char second = chars[j];

                // Step 3: Filter the string to keep only these two characters
                StringBuilder filtered = new StringBuilder();
                for (char c : s.toCharArray()) {
                    if (c == first || c == second) {
                        filtered.append(c);
                    }
                }

                // Step 4: Check if it's alternating
                if (isAlternating(filtered.toString())) {
                    maxLength = Math.max(maxLength, filtered.length());
                }
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt(); // Read length of string (not used)
        String s = scanner.next(); // Read string

        scanner.close();

        System.out.println(alternate(s)); // Print the longest alternating substring length
    }
}
