import java.util.*;

public class Solution {
    
    public static String gridChallenge(String[] grid) {
        int n = grid.length;
        
        // Sort each row alphabetically
        String[] sortedGrid = new String[n];
        for (int i = 0; i < n; i++) {
            char[] rowArr = grid[i].toCharArray();
            Arrays.sort(rowArr);
            sortedGrid[i] = new String(rowArr);
        }
        
        // Check if columns are sorted top-to-bottom
        int m = sortedGrid[0].length();  // number of columns
        for (int col = 0; col < m; col++) {
            for (int row = 0; row < n - 1; row++) {
                if (sortedGrid[row].charAt(col) > sortedGrid[row + 1].charAt(col)) {
                    return "NO";
                }
            }
        }
        return "YES";
    }
    
    // Main method for testing the solution using console input
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // The first input is the number of test cases
        int t = scanner.nextInt();
        scanner.nextLine();  // consume newline
        
        for (int test = 0; test < t; test++) {
            // The next input is the number of rows (and columns) in the grid
            int n = scanner.nextInt();
            scanner.nextLine();  // consume newline
            
            String[] grid = new String[n];
            for (int i = 0; i < n; i++) {
                grid[i] = scanner.nextLine();
            }
            
            System.out.println(gridChallenge(grid));
        }
        
        scanner.close();
    }
}

