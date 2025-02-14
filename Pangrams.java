import java.util.*;

public class Pangrams {
    public static String pangrams(String s) {
        // Convert to lowercase to make it case insensitive
        s = s.toLowerCase();

        // Use a HashSet to store unique letters
        Set<Character> letters = new HashSet<>();

        for (char c : s.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                letters.add(c);
            }
        }

        // Check if all 26 letters are present
        return (letters.size() == 26) ? "pangram" : "not pangram";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        scanner.close();

        System.out.println(pangrams(s));
    }
}
