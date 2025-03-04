import java.util.*;

public class EqualStacks {
    public static int equalStacks(int[] h1, int[] h2, int[] h3) {
        // Compute cumulative heights using stacks (bottom to top)
        Stack<Integer> stack1 = getCumulativeHeightStack(h1);
        Stack<Integer> stack2 = getCumulativeHeightStack(h2);
        Stack<Integer> stack3 = getCumulativeHeightStack(h3);

        // Use a set to find the common maximum height
        Set<Integer> heights1 = new HashSet<>(stack1);
        Set<Integer> heights2 = new HashSet<>(stack2);
        Set<Integer> heights3 = new HashSet<>(stack3);

        // Find the max height common to all three stacks
        int maxCommonHeight = 0;
        for (int height : heights1) {
            if (heights2.contains(height) && heights3.contains(height)) {
                maxCommonHeight = Math.max(maxCommonHeight, height);
            }
        }
        return maxCommonHeight;
    }

    private static Stack<Integer> getCumulativeHeightStack(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        for (int i = heights.length - 1; i >= 0; i--) { // Traverse from bottom to top
            sum += heights[i];
            stack.push(sum);
        }
        return stack;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read input sizes
        int n1 = scanner.nextInt();
        int n2 = scanner.nextInt();
        int n3 = scanner.nextInt();

        // Read stacks
        int[] h1 = new int[n1];
        for (int i = 0; i < n1; i++) h1[i] = scanner.nextInt();

        int[] h2 = new int[n2];
        for (int i = 0; i < n2; i++) h2[i] = scanner.nextInt();

        int[] h3 = new int[n3];
        for (int i = 0; i < n3; i++) h3[i] = scanner.nextInt();

        // Compute and print the result
        System.out.println(equalStacks(h1, h2, h3));

        scanner.close();
    }
}
