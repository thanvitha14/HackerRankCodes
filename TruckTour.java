import java.util.*;

public class TruckTour {
    public static int truckTour(List<int[]> petrolPumps) {
        int startIndex = 0;
        int totalPetrol = 0, currentPetrol = 0;

        for (int i = 0; i < petrolPumps.size(); i++) {
            int petrol = petrolPumps.get(i)[0];
            int distance = petrolPumps.get(i)[1];
            
            totalPetrol += petrol - distance;
            currentPetrol += petrol - distance;

            if (currentPetrol < 0) {
                startIndex = i + 1;
                currentPetrol = 0;
            }
        }

        return totalPetrol >= 0 ? startIndex : -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<int[]> petrolPumps = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int petrol = scanner.nextInt();
            int distance = scanner.nextInt();
            petrolPumps.add(new int[]{petrol, distance});
        }
        
        System.out.println(truckTour(petrolPumps));
        scanner.close();
    }
}