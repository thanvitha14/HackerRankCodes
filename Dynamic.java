import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static List<Integer> dynamicArray(int n, List<String> queries) {
        // Create a 2-dimensional list of n empty lists.
        List<List<Integer>> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(new ArrayList<>());
        }

        int lastAnswer = 0;
        List<Integer> answers = new ArrayList<>();

        // Process each query
        for (String query : queries) {
            String[] tokens = query.split(" ");
            int queryType = Integer.parseInt(tokens[0]);
            int x = Integer.parseInt(tokens[1]);
            int y = Integer.parseInt(tokens[2]);

            // Calculate index using the bitwise XOR operator
            int idx = (x ^ lastAnswer) % n;

            if (queryType == 1) {
                // Append y to arr[idx]
                arr.get(idx).add(y);
            } else if (queryType == 2) {
                // Find the element index in arr[idx] using modulo
                int size = arr.get(idx).size();
                lastAnswer = arr.get(idx).get(y % size);
                answers.add(lastAnswer);
            }
        }
        return answers;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read n (number of arrays) and q (number of queries)
        int n = sc.nextInt();
        int q = sc.nextInt();
        sc.nextLine();  // consume the rest of the line

        List<String> queries = new ArrayList<>();

        // Read all query strings
        for (int i = 0; i < q; i++) {
            queries.add(sc.nextLine());
        }

        // Process queries
        List<Integer> result = dynamicArray(n, queries);

        // Output each result from type 2 queries on a new line
        for (int answer : result) {
            System.out.println(answer);
        }
        
        sc.close();
    }
}

