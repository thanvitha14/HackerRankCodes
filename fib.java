import java.math.BigInteger;
import java.util.Scanner;

public class Solution {
    
    public static BigInteger fibonacciModified(BigInteger t1, BigInteger t2, int n) {
        // Compute terms from 3 to n using the recurrence:
        // t[i+2] = t[i] + (t[i+1])^2.
        for (int i = 3; i <= n; i++) {
            BigInteger next = t1.add(t2.multiply(t2)); // t1 + t2^2
            t1 = t2;
            t2 = next;
        }
        return t2;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read space-separated values: t1, t2, and n.
        BigInteger t1 = new BigInteger(scanner.next());
        BigInteger t2 = new BigInteger(scanner.next());
        int n = scanner.nextInt();
        scanner.close();
        
        BigInteger result = fibonacciModified(t1, t2, n);
        System.out.println(result);
    }
}