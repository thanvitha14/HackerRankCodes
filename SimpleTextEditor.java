import java.util.*;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int Q = scanner.nextInt(); // Number of operations
        scanner.nextLine(); // Consume newline

        StringBuilder S = new StringBuilder(); // Current text
        Stack<String> history = new Stack<>(); // Stack to store previous states
        
        StringBuilder output = new StringBuilder(); // To collect output for efficiency
        
        for (int i = 0; i < Q; i++) {
            String[] command = scanner.nextLine().split(" ");
            int type = Integer.parseInt(command[0]);

            switch (type) {
                case 1: // append(W)
                    history.push(S.toString()); // Save state before modification
                    S.append(command[1]);
                    break;

                case 2: // delete(k)
                    history.push(S.toString()); // Save state before modification
                    int k = Integer.parseInt(command[1]);
                    S.delete(S.length() - k, S.length());
                    break;

                case 3: // print(k)
                    int pos = Integer.parseInt(command[1]);
                    output.append(S.charAt(pos - 1)).append("\n");
                    break;

                case 4: // undo()
                    if (!history.isEmpty()) {
                        S = new StringBuilder(history.pop()); // Restore previous state
                    }
                    break;
            }
        }
        
        // Print all collected output at once (efficient for large inputs)
        System.out.print(output.toString());

        scanner.close();
    }
}
