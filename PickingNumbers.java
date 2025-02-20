import java.util.Scanner;

public class PickingNumbers {

    public static int pickingNumbers(int[] a) {
        // Since the values are between 0 and 100, we can use a frequency array.
        int[] frequency = new int[101];
        for (int num : a) {
            frequency[num]++;
        }
        
        int maxLength = 0;
        // Check each pair of adjacent numbers (i, i+1)
        for (int i = 0; i < frequency.length - 1; i++) {
            int currentLength = frequency[i] + frequency[i + 1];
            if (currentLength > maxLength) {
                maxLength = currentLength;
            }
        }
        
        return maxLength;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read the number of elements.
        int n = scanner.nextInt();
        int[] a = new int[n];
        
        // Read the array elements.
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        
        // Print the length of the longest subarray meeting the criteria.
        System.out.println(pickingNumbers(a));
        scanner.close();
    }
}

