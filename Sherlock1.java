import java.util.*;

public class Solution {
    public static int sherlockAndAnagrams(String s) {
        Map<String, Integer> freqMap = new HashMap<>();
        int count = 0;
        
        // Generate all substrings
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                char[] subArr = s.substring(i, j + 1).toCharArray();
                Arrays.sort(subArr); // Sorting ensures same anagrams get same key
                String key = new String(subArr);
                
                // Store in HashMap
                freqMap.put(key, freqMap.getOrDefault(key, 0) + 1);
            }
        }
        
        // Count anagram pairs
        for (int value : freqMap.values()) {
            count += (value * (value - 1)) / 2; // Combination formula
        }
        
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt(); // Number of test cases
        scanner.nextLine(); // Consume newline
        
        for (int i = 0; i < q; i++) {
            String s = scanner.nextLine();
            System.out.println(sherlockAndAnagrams(s));
        }
        
        scanner.close();
    }
}
