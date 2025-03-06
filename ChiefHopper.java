import java.util.*;

public class ChiefHopper {
    public static int minInitialEnergy(int[] arr) {
        int n = arr.length;
        int energy = 0;

        // Reverse traversal to calculate minimum energy required
        for (int i = n - 1; i >= 0; i--) {
            energy = (energy + arr[i] + 1) / 2;
        }
        
        return energy;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(minInitialEnergy(arr));
        sc.close();
    }
}
