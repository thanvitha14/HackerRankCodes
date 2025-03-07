import java.util.HashSet;
import java.util.Scanner;

public class TwoCharacters {
    public static int getMaxValidStringLength(String s) {
        HashSet<Character> uniqueChars = new HashSet<>();
        for (char c : s.toCharArray()) {
            uniqueChars.add(c);
        }

        int maxLength = 0;

        Character[] charArray = uniqueChars.toArray(new Character[0]);

        for (int i = 0; i < charArray.length; i++) {
            for (int j = i + 1; j < charArray.length; j++) {
                char first = charArray[i];
                char second = charArray[j];

                StringBuilder filtered = new StringBuilder();
                for (char c : s.toCharArray()) {
                    if (c == first || c == second) {
                        filtered.append(c);
                    }
                }

                if (isValid(filtered.toString())) {
                    maxLength = Math.max(maxLength, filtered.length());
                }
            }
        }

        return maxLength;
    }

    private static boolean isValid(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String s = scanner.next();
        scanner.close();

        System.out.println(getMaxValidStringLength(s));
    }
}