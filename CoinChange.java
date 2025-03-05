import java.util.*;

public class CoinChange {
    public static long getWays(int n, int[] c) {
        long[] dp = new long[n + 1]; // DP array to store ways to make each amount
        dp[0] = 1; // Base case: Only one way to make amount 0

        for (int coin : c) { // Iterate over each coin
            for (int j = coin; j <= n; j++) { // Update dp for all j >= coin
                dp[j] += dp[j - coin];
            }
        }
        return dp[n]; // Return number of ways to make amount 'n'
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read inputs
        int n = scanner.nextInt(); // Amount to make change for
        int m = scanner.nextInt(); // Number of coin denominations
        int[] c = new int[m];

        for (int i = 0; i < m; i++) {
            c[i] = scanner.nextInt(); // Read coin denominations
        }

        scanner.close();

        // Compute and print result
        System.out.println(getWays(n, c));
    }
}
