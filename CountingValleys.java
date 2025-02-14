import java.util.*;

public class CountingValleys {
    public static int countingValleys(int steps, String path) {
        int seaLevel = 0;
        int valleys = 0;
        int altitude = 0;

        for (char step : path.toCharArray()) {
            if (step == 'U') {
                altitude++;
            } else if (step == 'D') {
                altitude--;
            }

            // If we just came back to sea level from below, it's a valley
            if (altitude == 0 && step == 'U') {
                valleys++;
            }
        }

        return valleys;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int steps = scanner.nextInt();
        String path = scanner.next();
        scanner.close();

        int result = countingValleys(steps, path);
        System.out.println(result);
    }
}
