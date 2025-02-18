import java.util.Arrays;
import java.util.Scanner;

public class MaximumPerimeterTriangle {
    public static int[] maximumPerimeterTriangle(int[] sticks) {
        Arrays.sort(sticks);
        int n = sticks.length;

        // Try forming a triangle with the largest possible side lengths
        for (int i = n - 3; i >= 0; i--) {
            int a = sticks[i], b = sticks[i + 1], c = sticks[i + 2];
            if (a + b > c) { // Triangle Inequality Condition
                return new int[]{a, b, c};
            }
        }
        
        return new int[]{-1}; // No valid triangle found
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] sticks = new int[n];

        for (int i = 0; i < n; i++) {
            sticks[i] = scanner.nextInt();
        }
        
        int[] result = maximumPerimeterTriangle(sticks);
        for (int side : result) {
            System.out.print(side + " ");
        }
        scanner.close();
    }
}

