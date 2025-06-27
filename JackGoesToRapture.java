import java.io.*;
import java.util.*;

public class JackGoesToRapture {
    
    static class Pair implements Comparable<Pair> {
        int node;
        long cost;

        Pair(int node, long cost) {
            this.node = node;
            this.cost = cost;
        }

        public int compareTo(Pair other) {
            return Long.compare(this.cost, other.cost);
        }
    }

    public static void getCost(int g_nodes, List<Integer> g_from, List<Integer> g_to, List<Integer> g_weight) {
        List<List<Pair>> graph = new ArrayList<>();
        for (int i = 0; i <= g_nodes; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < g_from.size(); i++) {
            int u = g_from.get(i);
            int v = g_to.get(i);
            int w = g_weight.get(i);
            graph.get(u).add(new Pair(v, w));
            graph.get(v).add(new Pair(u, w));
        }

        long[] dist = new long[g_nodes + 1];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[1] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.offer(new Pair(1, 0));

        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int u = current.node;
            long costSoFar = current.cost;

            if (costSoFar > dist[u]) continue;

            for (Pair neighbor : graph.get(u)) {
                int v = neighbor.node;
                long fare = neighbor.cost;

                long newCost = costSoFar + Math.max(0, fare - costSoFar);

                if (newCost < dist[v]) {
                    dist[v] = newCost;
                    pq.offer(new Pair(v, newCost));
                }
            }
        }

        if (dist[g_nodes] == Long.MAX_VALUE) {
            System.out.println("NO PATH EXISTS");
        } else {
            System.out.println(dist[g_nodes]);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = br.readLine().split(" ");
        int g_nodes = Integer.parseInt(firstLine[0]);
        int g_edges = Integer.parseInt(firstLine[1]);

        List<Integer> g_from = new ArrayList<>();
        List<Integer> g_to = new ArrayList<>();
        List<Integer> g_weight = new ArrayList<>();

        for (int i = 0; i < g_edges; i++) {
            String[] parts = br.readLine().split(" ");
            g_from.add(Integer.parseInt(parts[0]));
            g_to.add(Integer.parseInt(parts[1]));
            g_weight.add(Integer.parseInt(parts[2]));
        }

        getCost(g_nodes, g_from, g_to, g_weight);
    }
}