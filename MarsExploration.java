import java.util.*;

public class MarsExploration {
    public static int marsExploration(String s) {
        int alteredCount = 0;
        String sos = "SOS";

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != sos.charAt(i % 3)) {
                alteredCount++;
            }
        }

        return alteredCount;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        scanner.close();

        System.out.println(marsExploration(s));
    }
}
