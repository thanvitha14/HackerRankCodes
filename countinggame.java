import java.util.Scanner;

public class CounterGame {

    public static String counterGame(long n) {
        int turnCount = 0;

        while (n > 1) {
            if ((n & (n - 1)) == 0) {
                n /= 2; // If n is a power of 2, divide by 2
            } else {
                n -= Long.highestOneBit(n); // Subtract the largest power of 2 less than n
            }
            turnCount++; // Increment turn count
        }

        return (turnCount % 2 == 0) ? "Richard" : "Louise";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(); // Number of test cases

        while (t-- > 0) {
            long n = scanner.nextLong(); // Read the number
            System.out.println(counterGame(n)); // Determine the winner
        }

        scanner.close();
    }
}

