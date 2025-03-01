import java.util.*;

public class SherlockValidString {
    public static String isValid(String s) {
        Map<Character, Integer> charCount = new HashMap<>();

        // Step 1: Count the frequency of each character
        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        // Step 2: Count frequency occurrences
        Map<Integer, Integer> freqCount = new HashMap<>();
        for (int freq : charCount.values()) {
            freqCount.put(freq, freqCount.getOrDefault(freq, 0) + 1);
        }

        // Step 3: Check conditions for a valid string
        if (freqCount.size() == 1) {
            return "YES"; // All characters have the same frequency
        } else if (freqCount.size() == 2) {
            List<Integer> keys = new ArrayList<>(freqCount.keySet());
            int f1 = keys.get(0), f2 = keys.get(1);

            // Case 1: One character appears only once and has frequency 1
            if ((freqCount.get(f1) == 1 && (f1 - 1 == 0 || f1 - 1 == f2)) ||
                (freqCount.get(f2) == 1 && (f2 - 1 == 0 || f2 - 1 == f1))) {
                return "YES";
            }
        }

        return "NO";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        scanner.close();
        System.out.println(isValid(s));
    }
}

