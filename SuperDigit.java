import java.util.Scanner;

public class SuperDigit {

    // Helper function to compute the super digit recursively
    private static int superDigitHelper(long num) {
        if (num < 10) {
            return (int) num; // Base case: If num is a single digit, return it
        }

        long sum = 0;
        while (num > 0) {
            sum += num % 10; // Add last digit
            num /= 10; // Remove last digit
        }

        return superDigitHelper(sum); // Recursive call
    }

    public static int superDigit(String n, int k) {
        long initialSum = 0;

        // Compute the sum of digits of n
        for (char digit : n.toCharArray()) {
            initialSum += Character.getNumericValue(digit);
        }

        // Multiply by k (since p = n repeated k times)
        long totalSum = initialSum * k;

        // Compute the super digit recursively
        return superDigitHelper(totalSum);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String n = scanner.next(); // Read string n
        int k = scanner.nextInt(); // Read integer k
        scanner.close();

        System.out.println(superDigit(n, k)); // Compute and print result
    }
}

