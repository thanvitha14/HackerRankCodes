import java.util.*;

public class Solution {

    public static int minimumNumber(int n, String password) {
        // Define the character sets required.
        String numbers = "0123456789";
        String lower_case = "abcdefghijklmnopqrstuvwxyz";
        String upper_case = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String special_characters = "!@#$%^&*()-+";
        
        // Booleans to check presence of each type.
        boolean hasDigit = false;
        boolean hasLower = false;
        boolean hasUpper = false;
        boolean hasSpecial = false;
        
        // Check each character in the password.
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (numbers.indexOf(c) != -1) {
                hasDigit = true;
            } else if (lower_case.indexOf(c) != -1) {
                hasLower = true;
            } else if (upper_case.indexOf(c) != -1) {
                hasUpper = true;
            } else if (special_characters.indexOf(c) != -1) {
                hasSpecial = true;
            }
        }
        
        // Count the number of character types missing.
        int missingTypes = 0;
        if (!hasDigit)
            missingTypes++;
        if (!hasLower)
            missingTypes++;
        if (!hasUpper)
            missingTypes++;
        if (!hasSpecial)
            missingTypes++;
        
        // The password must be at least 6 characters long.
        // We need to add enough characters to meet both the length requirement and the missing types.
        return Math.max(missingTypes, 6 - n);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String password = sc.next();
        System.out.println(minimumNumber(n, password));
        sc.close();
    }
}

