package SetsAndMapsAdvanced;

import java.util.*;
import java.util.stream.Collectors;

public class Lab08AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Double> students = new TreeMap<>();

        while (n > 0){
            String name = scanner.nextLine();
            List<Double> scores = Arrays.stream(scanner.nextLine().split(" ")).map(Double::parseDouble).collect(Collectors.toList());
            double sum = 0;
            for (Double score : scores) {
                sum += score;
            }
            double average = sum / scores.size();
            students.put(name, average);
            n--;
        }
        for (Map.Entry<String, Double> entry : students.entrySet()) {
            System.out.printf("%s is graduated with %s%n", entry.getKey(), entry.getValue());
        }
    }
}
