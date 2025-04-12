import java.util.*;

public class trra {
    static List<Integer>[] tree;
    static int[] data;
    static boolean[] visited;
    static int totalSum;
    static int minDifference;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        data = new int[n];
        tree = new ArrayList[n];
        visited = new boolean[n];
        totalSum = 0;
        minDifference = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            data[i] = sc.nextInt();
            totalSum += data[i];
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            int u = sc.nextInt() - 1;
            int v = sc.nextInt() - 1;
            tree[u].add(v);
            tree[v].add(u);
        }

        dfs(0);

        System.out.println(minDifference);
    }

    static int dfs(int node) {
        visited[node] = true;
        int sum = data[node];

        for (int neighbor : tree[node]) {
            if (!visited[neighbor]) {
                int subtreeSum = dfs(neighbor);
                int diff = Math.abs(totalSum - 2 * subtreeSum);
                minDifference = Math.min(minDifference, diff);
                sum += subtreeSum;
            }
        }

        return sum;
    }
}
