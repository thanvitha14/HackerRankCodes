import java.util.Scanner;

public class CamelCase {

    // Method to split a camelCase string into words
    public static String splitCamelCase(String camelCaseStr, String type) {
        StringBuilder result = new StringBuilder();
        
        // Traverse each character in the camelCase string
        for (int i = 0; i < camelCaseStr.length(); i++) {
            char currentChar = camelCaseStr.charAt(i);
            
            // If the character is uppercase and it is not the first character
            if (Character.isUpperCase(currentChar) && i > 0) {
                result.append(" "); // Add a space before uppercase letters
            }
            
            // Append the current character in lowercase
            result.append(Character.toLowerCase(currentChar));
        }
        
        // Handle special cases for Methods and Variables
        if (type.equals("M") && camelCaseStr.endsWith("()")) {
            result.delete(result.length() - 2, result.length()); // Remove parentheses for split
        }
        
        return result.toString();
    }

    // Method to combine words into a camelCase string
    public static String combineCamelCase(String type, String[] words) {
        StringBuilder result = new StringBuilder();
        
        // Process based on the type (Method, Variable, Class)
        if (type.equals("M")) { // Method
            result.append(words[0].toLowerCase()); // First word in lowercase
            for (int i = 1; i < words.length; i++) {
                result.append(Character.toUpperCase(words[i].charAt(0)))
                      .append(words[i].substring(1).toLowerCase());
            }
            result.append("()"); // Append parentheses for method
        } else if (type.equals("V")) { // Variable
            result.append(words[0].toLowerCase()); // First word in lowercase
            for (int i = 1; i < words.length; i++) {
                result.append(Character.toUpperCase(words[i].charAt(0)))
                      .append(words[i].substring(1).toLowerCase());
            }
        } else if (type.equals("C")) { // Class
            for (String word : words) {
                result.append(Character.toUpperCase(word.charAt(0)))
                      .append(word.substring(1).toLowerCase());
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Read input line by line
        while (sc.hasNextLine()) {
            String input = sc.nextLine();
            String[] parts = input.split(";");
            
            String operation = parts[0]; // S for split or C for combine
            String type = parts[1]; // M for method, V for variable, C for class
            String value = parts[2]; // The string to split or the words to combine
            
            if (operation.equals("S")) { // Split operation
                System.out.println(splitCamelCase(value, type));
            } else if (operation.equals("C")) { // Combine operation
                String[] words = value.split(" ");
                System.out.println(combineCamelCase(type, words));
            }
        }
        
        sc.close();
    }
}
