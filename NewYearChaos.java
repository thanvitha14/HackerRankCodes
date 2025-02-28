import java.util.*;

public class NewYearChaos {
    public static void minimumBribes(int[] q) {
        int bribes = 0;

        for (int i = 0; i < q.length; i++) {
            // Check if a person has moved more than 2 places ahead
            if (q[i] - (i + 1) > 2) {
                System.out.println("Too chaotic");
                return;
            }

            // Count how many times q[i] has been bribed
            // A person can only bribe from their original position -2 to current position
            for (int j = Math.max(0, q[i] - 2); j < i; j++) {
                if (q[j] > q[i]) {
                    bribes++;
                }
            }
        }

        System.out.println(bribes);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(); // Number of test cases

        while (t-- > 0) {
            int n = scanner.nextInt(); // Number of people in queue
            int[] q = new int[n];

            for (int i = 0; i < n; i++) {
                q[i] = scanner.nextInt();
            }

            minimumBribes(q);
        }

        scanner.close();
    }
}

