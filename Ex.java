import java.util.Scanner;

public class Solution {

    // Function to calculate the minimum number of pages to turn
    public static int pageCount(int n, int p) {
        // Turns from the front
        int fromFront = p / 2;

        // Turns from the back
        int fromBack = (n / 2) - (p / 2);

        // Return the minimum of the two
        return Math.min(fromFront, fromBack);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read input
        int n = scanner.nextInt(); // Total number of pages
        int p = scanner.nextInt(); // Target page

        // Output the result
        System.out.println(pageCount(n, p));

        scanner.close();
    }
}

