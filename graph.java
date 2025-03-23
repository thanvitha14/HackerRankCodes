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



public class Solution {
    
    private static final long inf = Long.MAX_VALUE;
    
    private static void floyd_warshall(List<Integer> roadFrom, List<Integer> roadTo, List<Integer> roadWeight, List<List<Integer>>queries) {
        
        int n = 0;
        for(int i : roadFrom) if(n < i) n = i;
        for(int i : roadTo) if(n < i) n = i;
        
        long[][] mat = new long[n][n];
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                mat[i][j] = inf;
            }
        }
        
        for(int i = 0; i < roadFrom.size(); i++) {
            mat[roadFrom.get(i) - 1][roadTo.get(i) - 1] = roadWeight.get(i);
        }
        
        floyd_warshall(mat);
        
        for(List<Integer> q : queries) {
            int x = q.get(0);
            int y = q.get(1);
            if(x == y) {
                System.out.println(0);
            } else if(mat[x-1][y-1] == inf) {
                System.out.println(-1);
            } else {
                System.out.println(mat[x-1][y-1]);
            }
        }
        
    }
    
    private static void floyd_warshall(long[][] mat) {
        int n = mat.length;
        for(int k = 0; k < n; k++) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(mat[i][k] != inf && mat[k][j] != inf) {
                        mat[i][j] = Math.min(mat[i][j], mat[i][k] + mat[k][j]);
                    }
                }
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] roadNodesEdges = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int roadNodes = Integer.parseInt(roadNodesEdges[0]);
        int roadEdges = Integer.parseInt(roadNodesEdges[1]);

        List<Integer> roadFrom = new ArrayList<>();
        List<Integer> roadTo = new ArrayList<>();
        List<Integer> roadWeight = new ArrayList<>();

        IntStream.range(0, roadEdges).forEach(i -> {
            try {
                String[] roadFromToWeight = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                roadFrom.add(Integer.parseInt(roadFromToWeight[0]));
                roadTo.add(Integer.parseInt(roadFromToWeight[1]));
                roadWeight.add(Integer.parseInt(roadFromToWeight[2]));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int q = Integer.parseInt(bufferedReader.readLine().trim());
        
        List<List<Integer>> queries = new ArrayList<List<Integer>>();

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
                List<Integer> k = new ArrayList<Integer>();

                int x = Integer.parseInt(firstMultipleInput[0]);
                int y = Integer.parseInt(firstMultipleInput[1]);
                k.add(x);
                k.add(y);
                queries.add(k);
                
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
    floyd_warshall(roadFrom, roadTo, roadWeight, queries);
bufferedReader.close();
}
}
