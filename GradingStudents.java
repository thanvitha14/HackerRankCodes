import java.util.*;

public class GradingStudents {
    public static List<Integer> gradingStudents(List<Integer> grades) {
        List<Integer> roundedGrades = new ArrayList<>();
        
        for (int grade : grades) {
            if (grade < 38) {
                roundedGrades.add(grade);
            } else {
                int nextMultipleOf5 = ((grade / 5) + 1) * 5;
                if (nextMultipleOf5 - grade < 3) {
                    roundedGrades.add(nextMultipleOf5);
                } else {
                    roundedGrades.add(grade);
                }
            }
        }
        
        return roundedGrades;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); 
        List<Integer> grades = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            grades.add(scanner.nextInt());
        }

        List<Integer> result = gradingStudents(grades);
        for (int grade : result) {
            System.out.println(grade);
        }
        
        scanner.close();
    }
}