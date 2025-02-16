import java.util.*;

public class Solution {

    public static int migratoryBirds(List<Integer> arr) {
        // Step 1: Use a HashMap to store the frequency of each bird type
        HashMap<Integer, Integer> birdCount = new HashMap<>();
        
        // Count the frequency of each bird type
        for (int bird : arr) {
            birdCount.put(bird, birdCount.getOrDefault(bird, 0) + 1);
        }

        // Step 2: Find the bird with the highest frequency
        int maxCount = -1;
        int resultBird = Integer.MAX_VALUE;

        for (Map.Entry<Integer, Integer> entry : birdCount.entrySet()) {
            int birdType = entry.getKey();
            int count = entry.getValue();
            
            // Update the result if we find a bird with higher frequency or same frequency but smaller ID
            if (count > maxCount || (count == maxCount && birdType < resultBird)) {
                maxCount = count;
                resultBird = birdType;
            }
        }

        // Step 3: Return the bird type with the highest frequency
        return resultBird;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();  // Number of bird sightings
        List<Integer> arr = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());  // Read the bird type IDs
        }

        // Call the migratoryBirds function and print the result
        int result = migratoryBirds(arr);
        System.out.println(result);
    }
}
