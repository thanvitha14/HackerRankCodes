import java.util.*;

public class big {

    public static List<String> bigSorting(List<String> unsorted) {
        Collections.sort(unsorted, new Comparator<String>() {
            public int compare(String a, String b) {
                // Compare by length first
                if (a.length() != b.length()) {
                    return a.length() - b.length();
                } else {
                    // If lengths are equal, compare lexicographically
                    return a.compareTo(b);
                }
            }
        });
        return unsorted;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<String> unsorted = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            unsorted.add(scanner.nextLine());
        }

        List<String> result = bigSorting(unsorted);
        for (String num : result) {
            System.out.println(num);
        }

        scanner.close();
    }
}
