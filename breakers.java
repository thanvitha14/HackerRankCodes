import java.util.*;

public class Solution {

    // Function that determines the winner
    static int towerBreakers(int n, int m) {
        // If no move can be made, Player 2 wins.
        if(m == 1) {
            return 2;
        }
        // When m > 1, if n is odd then Player 1 wins; if even then Player 2 wins.
        return (n % 2 == 1) ? 1 : 2;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();  // number of test cases
        for (int test = 0; test < t; test++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            System.out.println(towerBreakers(n, m));
        }
        sc.close();
    }
}
