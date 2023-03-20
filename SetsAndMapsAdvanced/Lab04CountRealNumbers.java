package SetsAndMapsAdvanced;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Lab04CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] values = Arrays.stream(scanner.nextLine().split("\\s+")).
                mapToDouble(Double::parseDouble).toArray();

        Map<Double, Integer> occurrences = new LinkedHashMap<>();

        for(int i = 0; i < values.length; i++){
            if(!occurrences.containsKey(values[i])){
                occurrences.put(values[i], 1);
            }else {
                occurrences.put(values[i], occurrences.get(values[i]) + 1);
            }
        }
        for (Double aDouble : occurrences.keySet()) {
            System.out.printf("%.1f -> %d%n", aDouble, occurrences.get(aDouble));
        }
    }
}
