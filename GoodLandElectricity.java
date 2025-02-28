import java.util.*;

public class GoodlandElectricity {

    public static int pylons(int k, int[] arr) {
        int n = arr.length;
        int count = 0;
        int i = 0;

        while (i < n) {
            // Find the rightmost possible plant within the range
            int plant = -1;
            for (int j = Math.min(i + k - 1, n - 1); j >= Math.max(i - (k - 1), 0); j--) {
                if (arr[j] == 1) {
                    plant = j;
                    break;
                }
            }

            // If no valid plant was found, it's impossible to cover all cities
            if (plant == -1) return -1;

            // Place the plant and move to the next uncovered city
            count++;
            i = plant + k; // Next uncovered city is beyond this plant's range
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        scanner.close();
        System.out.println(pylons(k, arr));
    }
}

