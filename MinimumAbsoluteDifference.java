import java.util.*;

public class MinimumAbsoluteDifference {

    public static int minimumAbsoluteDifference(int[] arr) {
        // Sort the array to bring elements with the smallest differences together.
        Arrays.sort(arr);
        
        // Initialize the minimum difference to a large value.
        int minDiff = Integer.MAX_VALUE;
        
        // Loop through the sorted array to compare adjacent elements.
        for (int i = 0; i < arr.length - 1; i++) {
            int diff = Math.abs(arr[i + 1] - arr[i]);
            if (diff < minDiff) {
                minDiff = diff;
            }
        }
        return minDiff;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read the number of elements.
        int n = scanner.nextInt();
        int[] arr = new int[n];
        
        // Read the array elements.
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        
        // Compute and print the minimum absolute difference.
        System.out.println(minimumAbsoluteDifference(arr));
        
        scanner.close();
    }
}

