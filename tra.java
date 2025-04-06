import java.util.*;

public class tra {
    public static int pairs(int k, int[] arr) {
        Set<Integer> set = new HashSet<>();
        int count = 0;

        for (int num : arr) {
            set.add(num);
        }

        for (int num : arr) {
            if (set.contains(num + k)) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(pairs(k, arr));
        sc.close();
    }
}