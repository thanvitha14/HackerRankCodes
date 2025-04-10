import java.util.Scanner;

public class ConnectedCell {

    static int[][] matrix;
    static int n, m;

    public static int connectedCell(int[][] grid) {
        matrix = grid;
        n = matrix.length;
        m = matrix[0].length;
        int maxRegion = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 1) {
                    int size = dfs(i, j);
                    maxRegion = Math.max(maxRegion, size);
                }
            }
        }

        return maxRegion;
    }

    private static int dfs(int i, int j) {
        // Check bounds and if cell is already visited or zero
        if (i < 0 || i >= n || j < 0 || j >= m || matrix[i][j] == 0) {
            return 0;
        }

        matrix[i][j] = 0; // mark as visited
        int size = 1;     // count this cell

        // Explore all 8 directions
        for (int row = -1; row <= 1; row++) {
            for (int col = -1; col <= 1; col++) {
                if (row != 0 || col != 0) {
                    size += dfs(i + row, j + col);
                }
            }
        }

        return size;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // number of rows
        m = sc.nextInt(); // number of columns

        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        System.out.println(connectedCell(grid));
    }
}