import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
 
class Cost implements Comparable<Cost> {
    public int r, v;
    public Cost(int cost, int vertex) {
        r = cost;
        v = vertex;
    }
    @Override
    public int compareTo(Cost c) {
        if (r < c.r) return -1;
        if (r> c.r) return 1;
        if (v < c.v) return -1;
        if (v > c.v) return 1;
        return 0;
    }
}
 
 
class Result {
 
    /*
     * Complete the 'prims' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY edges
     *  3. INTEGER start
     */
     
     
     // Slide mst.p52
     public static boolean[] marked;
     public static PriorityQueue<Cost> pq;
     public static List<Cost> mstCosts;
     
    public static void visit(List<List<Cost>> danhsachlienke, int v) {
        marked[v] = true;
        for(Cost cost : danhsachlienke.get(v)) {
            if (!marked[cost.v]) {
                pq.add(cost);
            }
        }
    }
 
    public static int prims(int n, List<List<Integer>> edges, int start) {
        List<List<Cost>> danhsachlienke = new ArrayList<>(n + 1);
        pq = new PriorityQueue<Cost>();
        marked = new boolean[n+1];
        mstCosts = new ArrayList<Cost>();
        
        for(int i = 0; i < n + 1; ++i) {
            danhsachlienke.add(new ArrayList<Cost>());
        }
        
        for (List<Integer> edge : edges) {
            // System.out.println(edge.get(0) + " " + edge.get(1) + " " + edge.get(2));
            danhsachlienke.get(edge.get(0)).add(new Cost(edge.get(2), edge.get(1)));
            danhsachlienke.get(edge.get(1)).add(new Cost(edge.get(2), edge.get(0)));
        }
        
        visit(danhsachlienke, start);
        
        // mstCosts.size() == mstEdges.size()
        while (!pq.isEmpty() && mstCosts.size() < n - 1) {
            Cost cost = pq.poll();
            if (marked[cost.v]) {
                continue;
            } else {
                mstCosts.add(cost);
                visit(danhsachlienke, cost.v);
            }
        }
        
        int total = 0;
        for (Cost cost : mstCosts) {
            total += cost.r;
        }
        return total;
    }
 
}
 
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
 
        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
 
        int n = Integer.parseInt(firstMultipleInput[0]);
 
        int m = Integer.parseInt(firstMultipleInput[1]);
 
        List<List<Integer>> edges = new ArrayList<>();
 
        IntStream.range(0, m).forEach(i -> {
            try {
                edges.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
 
        int start = Integer.parseInt(bufferedReader.readLine().trim());
 
        int result = Result.prims(n, edges, start);
 
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
 
        bufferedReader.close();
        bufferedWriter.close();
    }
}

