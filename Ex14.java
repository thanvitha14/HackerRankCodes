import java.util.*;

public class Solution {

    public static List<Integer> rotateLeft(int d, List<Integer> arr) {
        int n = arr.size();
        d = d % n;  // To handle cases where d > n
        
        // Get the two parts of the array and concatenate them
        List<Integer> rotated = new ArrayList<>();
        rotated.addAll(arr.subList(d, n));  // Add the part from index d to n-1
        rotated.addAll(arr.subList(0, d));  // Add the part from index 0 to d-1
        
        return rotated;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read the number of elements and number of rotations
        int n = scanner.nextInt();
        int d = scanner.nextInt();
        
        // Read the array elements
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(scanner.nextInt());
        }
        
        // Perform the rotations
        List<Integer> result = rotateLeft(d, arr);
        
        // Print the rotated array
        for (int num : result) {
            System.out.print(num + " ");
        }
        scanner.close();
    }
}
