import java.util.*;

public class MagicSquare {
    
    public static int formingMagicSquare(int[][] s) {
        // List of all possible 3x3 magic squares
        int[][][] magicSquares = {
            {{8, 1, 6}, {3, 5, 7}, {4, 9, 2}},
            {{6, 1, 8}, {7, 5, 3}, {2, 9, 4}},
            {{4, 9, 2}, {3, 5, 7}, {8, 1, 6}},
            {{2, 9, 4}, {7, 5, 3}, {6, 1, 8}},
            {{8, 3, 4}, {1, 5, 9}, {6, 7, 2}},
            {{4, 3, 8}, {9, 5, 1}, {2, 7, 6}},
            {{6, 7, 2}, {1, 5, 9}, {8, 3, 4}},
            {{2, 7, 6}, {9, 5, 1}, {4, 3, 8}}
        };

        int minCost = Integer.MAX_VALUE;

        // Compare input matrix with each possible magic square
        for (int[][] magic : magicSquares) {
            int cost = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    cost += Math.abs(s[i][j] - magic[i][j]); // Compute cost
                }
            }
            minCost = Math.min(minCost, cost); // Track minimum cost
        }

        return minCost;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] s = new int[3][3];

        // Read the input matrix
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                s[i][j] = scanner.nextInt();
            }
        }
        
        scanner.close();
        System.out.println(formingMagicSquare(s)); // Output the minimum cost
    }
}

