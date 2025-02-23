import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Read the first array, arr
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        // Read the second array, brr
        int m = sc.nextInt();
        int[] brr = new int[m];
        for (int i = 0; i < m; i++) {
            brr[i] = sc.nextInt();
        }
        
        // Frequency maps for arr and brr
        HashMap<Integer, Integer> freqArr = new HashMap<>();
        HashMap<Integer, Integer> freqBrr = new HashMap<>();
        
        // Count frequencies for arr
        for (int num : arr) {
            freqArr.put(num, freqArr.getOrDefault(num, 0) + 1);
        }
        
        // Count frequencies for brr
        for (int num : brr) {
            freqBrr.put(num, freqBrr.getOrDefault(num, 0) + 1);
        }
        
        // Use a TreeSet to collect missing numbers in sorted order
        TreeSet<Integer> missingNumbers = new TreeSet<>();
        for (Integer key : freqBrr.keySet()) {
            int countBrr = freqBrr.get(key);
            int countArr = freqArr.getOrDefault(key, 0);
            if (countBrr > countArr) {
                missingNumbers.add(key);
            }
        }
        
        // Print the missing numbers separated by a space
        StringBuilder output = new StringBuilder();
        for (Integer num : missingNumbers) {
            output.append(num).append(" ");
        }
        System.out.println(output.toString().trim());
        
        sc.close();
    }
}

