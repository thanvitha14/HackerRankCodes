import java.util.Scanner;

public class GamingArray {

    public static String gamingArray(int[] arr) {
        int maxSoFar = 0, moves = 0;

        // Traverse the array and count the number of times a new max appears
        for (int num : arr) {
            if (num > maxSoFar) {
                maxSoFar = num;
                moves++; // Every new maximum means a new move
            }
        }

        // If the number of moves is odd, Bob wins; if even, Andy wins
        return (moves % 2 == 1) ? "BOB" : "ANDY";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int g = scanner.nextInt(); // Number of games

        while (g-- > 0) {
            int n = scanner.nextInt(); // Number of elements in array
            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }

            System.out.println(gamingArray(arr)); // Determine and print the winner
        }

        scanner.close();
    }
}

