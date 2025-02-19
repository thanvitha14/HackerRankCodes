import java.util.Scanner;

public class KangarooJump {

    public static String kangaroo(int x1, int v1, int x2, int v2) {
        // If the first kangaroo's speed is less than or equal to the second's,
        // it will never catch up because x1 < x2.
        if (v1 <= v2) {
            return "NO";
        }
        
        // Check if the difference in starting positions is evenly divisible
        // by the difference in speeds.
        if ((x2 - x1) % (v1 - v2) == 0) {
            return "YES";
        }
        
        return "NO";
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Read four integers from input.
        int x1 = scanner.nextInt();
        int v1 = scanner.nextInt();
        int x2 = scanner.nextInt();
        int v2 = scanner.nextInt();
        
        // Print the result.
        System.out.println(kangaroo(x1, v1, x2, v2));
        scanner.close();
    }
}
