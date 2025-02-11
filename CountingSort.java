import java.util.Scanner;

public class CountingSort {

    public static int[] countingSort(int[] arr) {
        // Create an array of size 100 initialized to 0
        int[] count = new int[100];
        
        // Iterate through the input array and update the count array
        for (int num : arr) {
            count[num]++;
        }
        
        // Return the count array which is the frequency array
        return count;
    }
    
    public static void main(String[] args) {
        // Scanner to read the input
        Scanner scanner = new Scanner(System.in);
        
        // Read the number of elements
        int n = scanner.nextInt();
        
        // Create the input array
        int[] arr = new int[n];
        
        // Read the input array
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        
        // Get the frequency array
        int[] result = countingSort(arr);
        
        // Print the frequency array
        for (int i = 0; i < 100; i++) {
            System.out.print(result[i] + " ");
        }
        
        // Close the scanner
        scanner.close();
    }
}
