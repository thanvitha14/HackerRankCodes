import java.util.*;

public class FlippingBits {
    public static long flippingBits(int n) {
        return (~(long) n) & 0xFFFFFFFFL;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt(); // Number of queries

        for (int i = 0; i < q; i++) {
            long n = scanner.nextLong(); // Read input as long to handle large values
            System.out.println(flippingBits((int) n)); // Convert to int and process
        }

        scanner.close();
    }
}