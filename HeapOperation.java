import java.util.*;

public class HeapOperation {

    public static void processQueries(int Q, List<String> queries) {
        // Min-heap to store the elements
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        // Set to track logically deleted elements
        Set<Integer> deleted = new HashSet<>();

        for (String query : queries) {
            String[] parts = query.split(" ");
            int operation = Integer.parseInt(parts[0]);

            if (operation == 1) {
                // Insert operation: Insert the element into the heap
                int element = Integer.parseInt(parts[1]);
                heap.offer(element);
            } else if (operation == 2) {
                // Delete operation: Mark the element as deleted (logically)
                int element = Integer.parseInt(parts[1]);
                deleted.add(element);
            } else if (operation == 3) {
                // Print the minimum element in the heap
                // Remove elements from the heap top that are logically deleted
                while (!heap.isEmpty() && deleted.contains(heap.peek())) {
                    heap.poll(); // Remove the element from the heap
                }

                // Print the current minimum element
                if (!heap.isEmpty()) {
                    System.out.println(heap.peek());
                }
            }
        }
    }

    public static void main(String[] args) {
        // Read input
        Scanner scanner = new Scanner(System.in);
        int Q = scanner.nextInt();
        scanner.nextLine();  // Consume the newline after the integer input

        List<String> queries = new ArrayList<>();
        for (int i = 0; i < Q; i++) {
            queries.add(scanner.nextLine());
        }

        // Process the queries
        processQueries(Q, queries);
        scanner.close();
    }
}

