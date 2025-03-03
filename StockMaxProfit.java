import java.util.*;

public class StockMaxProfit {
    public static long stockmax(int[] prices) {
        long profit = 0;
        int maxPrice = 0;

        // Traverse the array from right to left
        for (int i = prices.length - 1; i >= 0; i--) {
            if (prices[i] > maxPrice) {
                maxPrice = prices[i];  // Update the max price
            }
            profit += maxPrice - prices[i];  // Buy at prices[i], sell at maxPrice
        }

        return profit;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();  // Number of test cases

        for (int test = 0; test < t; test++) {
            int n = scanner.nextInt();  // Number of days
            int[] prices = new int[n];

            for (int i = 0; i < n; i++) {
                prices[i] = scanner.nextInt();
            }

            System.out.println(stockmax(prices));
        }

        scanner.close();
    }
}
