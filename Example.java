import java.util.*;

public class Solution {

    public static int sockMerchant(int n, List<Integer> ar) {
        // Step 1: Create a HashMap to store the frequency of each sock color
        HashMap<Integer, Integer> sockCount = new HashMap<>();
        
        // Step 2: Count the frequency of each color in the array
        for (int color : ar) {
            sockCount.put(color, sockCount.getOrDefault(color, 0) + 1);
        }

        // Step 3: Calculate the total number of pairs
        int totalPairs = 0;
        for (int count : sockCount.values()) {
            totalPairs += count / 2;  // Add the number of pairs (integer division)
        }

        // Step 4: Return the total number of pairs
        return totalPairs;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();  // Number of socks
        List<Integer> ar = new ArrayList<>();
        
        // Read the colors of socks
        for (int i = 0; i < n; i++) {
            ar.add(sc.nextInt());
        }

        // Call the sockMerchant function and print the result
        int result = sockMerchant(n, ar);
        System.out.println(result);
    }
}
