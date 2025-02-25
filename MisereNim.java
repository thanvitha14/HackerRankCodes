import java.util.Scanner;

public class MisereNim {
    public static String misereNim(Scanner scanner) {
        int n = scanner.nextInt(); // Number of piles
        int nimSum = 0;
        boolean allOnes = true;

        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();
            nimSum ^= num; // Compute nimSum
            if (num > 1) allOnes = false; // Check if at least one pile has >1 stone
        }

        // If all piles contain only 1 stone
        if (allOnes) {
            return (n % 2 == 0) ? "First" : "Second";
        }

        return (nimSum == 0) ? "Second" : "First";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); // Number of test cases

        while (T-- > 0) {
            System.out.println(misereNim(scanner));
        }

        scanner.close();
    }
}

