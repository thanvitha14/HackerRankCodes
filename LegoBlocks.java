import java.util.Scanner;

public class LegoBlocks {
    static final int MOD = 1000000007;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();  // Number of test cases
        
        int maxM = 1000;  // Maximum width constraint
        long[] rowWays = computeRowWays(maxM);
        
        while (t-- > 0) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            System.out.println(solve(n, m, rowWays));
        }
        scanner.close();
    }

    private static long[] computeRowWays(int maxM) {
        long[] rowWays = new long[maxM + 1];
        rowWays[0] = 1;  // Base case: 1 way to build an empty row
        rowWays[1] = 1;  // Only 1 way to build a row of width 1
        rowWays[2] = 2;  // (1+1) or (2)
        rowWays[3] = 4;  // (1+1+1), (1+2), (2+1), (3)
        rowWays[4] = 8;  // (1+1+1+1), (1+1+2), (1+2+1), (2+1+1), (2+2), (3+1), (1+3), (4)

        for (int i = 5; i <= maxM; i++) {
            rowWays[i] = (rowWays[i - 1] + rowWays[i - 2] + rowWays[i - 3] + rowWays[i - 4]) % MOD;
        }
        return rowWays;
    }

    private static long solve(int n, int m, long[] rowWays) {
        long[] totalWays = new long[m + 1];
        long[] solidWays = new long[m + 1];

        // Compute totalWays[m] = (rowWays[m])^n
        for (int i = 1; i <= m; i++) {
            totalWays[i] = power(rowWays[i], n, MOD);
        }

        // Compute solid ways using the inclusion-exclusion principle
        for (int i = 1; i <= m; i++) {
            solidWays[i] = totalWays[i];
            for (int j = 1; j < i; j++) {
                solidWays[i] = (solidWays[i] - (solidWays[j] * totalWays[i - j]) % MOD + MOD) % MOD;
            }
        }

        return solidWays[m];
    }

    private static long power(long base, int exp, int mod) {
        long result = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp >>= 1;
        }
        return result;
    }
}
