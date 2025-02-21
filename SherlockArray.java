import java.util.*;

public class SherlockArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // Number of test cases

        while (T-- > 0) {
            int n = sc.nextInt(); // Size of array
            int[] arr = new int[n];
            
            int totalSum = 0;
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
                totalSum += arr[i]; // Compute total sum
            }
            
            System.out.println(balancedSums(arr, totalSum));
        }
        
        sc.close();
    }

    public static String balancedSums(int[] arr, int totalSum) {
        int leftSum = 0;

        for (int num : arr) {
            if (leftSum == totalSum - leftSum - num) {
                return "YES"; // Found equilibrium index
            }
            leftSum += num;
        }

        return "NO"; // No equilibrium index found
    }
}
