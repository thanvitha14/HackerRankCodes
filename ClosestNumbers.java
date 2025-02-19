import java.util.*;

public class ClosestNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read the number of elements
        int n = scanner.nextInt();
        int[] arr = new int[n];
        
        // Read the array elements
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        
        // Sort the array to make it easier to find minimum differences
        Arrays.sort(arr);
        
        // Find the minimum difference between consecutive elements
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < n - 1; i++) {
            int diff = arr[i + 1] - arr[i];
            if (diff < minDiff) {
                minDiff = diff;
            }
        }
        
        // Gather all pairs that have the minimum difference
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            int diff = arr[i + 1] - arr[i];
            if (diff == minDiff) {
                result.add(arr[i]);
                result.add(arr[i + 1]);
            }
        }
        
        // Print the result as space-separated integers on one line
        for (int num : result) {
            System.out.print(num + " ");
        }
        
        scanner.close();
    }
}