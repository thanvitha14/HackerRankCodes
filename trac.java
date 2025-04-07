import java.util.*;

public class trac {
    public static void almostSorted(int[] arr) {
        int n = arr.length;
        int[] sorted = arr.clone();
        Arrays.sort(sorted);

        // Find the first and last mismatch positions
        int l = 0, r = n - 1;
        while (l < n && arr[l] == sorted[l]) l++;
        while (r > l && arr[r] == sorted[r]) r--;

        if (l >= r) {
            // The array is already sorted
            System.out.println("yes");
            return;
        }

        // Try swapping
        swap(arr, l, r);
        if (Arrays.equals(arr, sorted)) {
            System.out.println("yes");
            System.out.println("swap " + (l + 1) + " " + (r + 1));
            return;
        }

        // Undo swap and try reverse
        swap(arr, l, r);
        reverse(arr, l, r);
        if (Arrays.equals(arr, sorted)) {
            System.out.println("yes");
            System.out.println("reverse " + (l + 1) + " " + (r + 1));
        } else {
            System.out.println("no");
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private static void reverse(int[] arr, int l, int r) {
        while (l < r) {
            swap(arr, l, r);
            l++;
            r--;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        almostSorted(arr);
    }
}
