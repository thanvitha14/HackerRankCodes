import java.util.*;

public class MaximumSubarray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(); // Number of test cases

        while (t-- > 0) {
            int n = scanner.nextInt(); // Array size
            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }

            // Compute results
            int maxSubarraySum = kadaneAlgorithm(arr);
            int maxSubsequenceSum = maxSubsequenceSum(arr);

            // Print results
            System.out.println(maxSubarraySum + " " + maxSubsequenceSum);
        }

        scanner.close();
    }

    // Function to find Maximum Subarray Sum using Kadane's Algorithm
    private static int kadaneAlgorithm(int[] arr) {
        int maxCurrent = arr[0], maxGlobal = arr[0];

        for (int i = 1; i < arr.length; i++) {
            maxCurrent = Math.max(arr[i], maxCurrent + arr[i]);
            maxGlobal = Math.max(maxGlobal, maxCurrent);
        }

        return maxGlobal;
    }

    // Function to find Maximum Subsequence Sum
    private static int maxSubsequenceSum(int[] arr) {
        int maxElement = Integer.MIN_VALUE, sum = 0;
        boolean hasPositive = false;

        for (int num : arr) {
            if (num > 0) {
                sum += num;
                hasPositive = true;
            }
            maxElement = Math.max(maxElement, num);
        }

        return hasPositive ? sum : maxElement;
    }
}
