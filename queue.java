import java.util.*;

public class QueueUsingTwoStacks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();  // Number of queries

        Stack<Integer> stack1 = new Stack<>();  // Enqueue stack
        Stack<Integer> stack2 = new Stack<>();  // Dequeue stack

        while (q-- > 0) {
            int type = scanner.nextInt();

            if (type == 1) {  // Enqueue operation
                int x = scanner.nextInt();
                stack1.push(x);
            } else if (type == 2) {  // Dequeue operation
                if (stack2.isEmpty()) {
                    while (!stack1.isEmpty()) {
                        stack2.push(stack1.pop());
                    }
                }
                if (!stack2.isEmpty()) {
                    stack2.pop();
                }
            } else if (type == 3) {  // Print front operation
                if (stack2.isEmpty()) {
                    while (!stack1.isEmpty()) {
                        stack2.push(stack1.pop());
                    }
                }
                if (!stack2.isEmpty()) {
                    System.out.println(stack2.peek());
                }
            }
        }
        scanner.close();
    }
}
