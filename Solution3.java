import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();  // Number of queries
        
        for (int query = 0; query < q; query++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            
            int[] A = new int[n];
            int[] B = new int[n];
            
            // Read array A
            for (int i = 0; i < n; i++) {
                A[i] = scanner.nextInt();
            }
            // Read array B
            for (int i = 0; i < n; i++) {
                B[i] = scanner.nextInt();
            }
            
            System.out.println(twoArrays(k, A, B));
        }
        scanner.close();
    }
    
    public static String twoArrays(int k, int[] A, int[] B) {
        // Sort A in ascending order
        Arrays.sort(A);
        // Sort B in ascending order first, then we'll pair elements from the end of B
        Arrays.sort(B);
        
        // Check the condition pairing A[i] with B[n-1-i]
        for (int i = 0; i < A.length; i++) {
            if (A[i] + B[B.length - 1 - i] < k) {
                return "NO";
            }
        }
        return "YES";
    }
}
