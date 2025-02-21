import java.util.*;

public class Solution {

    public static int maxMin(int k, int[] arr) {
        Arrays.sort(arr);
        int minUnfairness = Integer.MAX_VALUE;
        // Slide a window of size k through the sorted array.
        for (int i = 0; i <= arr.length - k; i++) {
            int currentUnfairness = arr[i + k - 1] - arr[i];
            if (currentUnfairness < minUnfairness) {
                minUnfairness = currentUnfairness;
            }
        }
        return minUnfairness;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // First input: number of elements in the array.
        int n = scanner.nextInt();
        // Second input: number k (the number of elements to select).
        int k = scanner.nextInt();
        
        int[] arr = new int[n];
        // Read the n integers.
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        
        // Output the minimum possible unfairness.
        System.out.println(maxMin(k, arr));
        
        scanner.close();
    }
}

