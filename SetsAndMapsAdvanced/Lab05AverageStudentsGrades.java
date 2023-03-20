package SetsAndMapsAdvanced;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Lab05AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, ArrayList<Double>> studentGrades = new TreeMap<>();

        while (n>0){
            String[] input = scanner.nextLine().split(" ");
            String name = input[0];
            double grade = Double.parseDouble(input[1]);
            ArrayList<Double> current = studentGrades.get(name);
            if(!studentGrades.containsKey(name)){
                ArrayList<Double> grades = new ArrayList<>();
                grades.add(grade);
                studentGrades.put(name, grades);
            }else {
                current.add(grade);
                studentGrades.put(name, current);
            }
            n--;
        }
        for (Map.Entry<String, ArrayList<Double>> entry : studentGrades.entrySet()) {
            ArrayList<Double> current = entry.getValue();
            double sum = 0.0;
            for (Double aDouble : current) {
                sum += aDouble;
            }
            double average = sum / current.size();

            System.out.printf("%s -> ", entry.getKey());
            for (Double aDouble : current) {
                System.out.printf("%.2f ", aDouble);
            }
            System.out.printf("(avg: %.2f)%n", average);
        }
    }
}
