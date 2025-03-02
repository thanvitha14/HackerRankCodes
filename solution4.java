import java.util.Scanner;
import java.util.Stack;

public class Solution {
    public static String superReducedString(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char ch : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == ch) {
                stack.pop(); // Remove adjacent duplicate
            } else {
                stack.push(ch); // Push if no duplicate
            }
        }
        
        // Convert stack back to string
        StringBuilder result = new StringBuilder();
        for (char ch : stack) {
            result.append(ch);
        }
        
        return result.length() == 0 ? "Empty String" : result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(superReducedString(s));
        scanner.close();
    }
}
