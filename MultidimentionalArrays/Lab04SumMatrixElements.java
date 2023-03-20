package MultidimentionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class Lab04SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] dimensions = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] matrix = new int[rows][];
         for(int i = 0; i < matrix.length; i++){
             int[] arr = Arrays.stream(scanner.nextLine().split(",\\s+"))
                     .mapToInt(Integer::parseInt).toArray();
             matrix[i] = arr;
         }

         int sum = 0;
         for (int i = 0; i < matrix.length; i++){
             for(int j = 0; j < matrix[i].length; j++){
                 sum += matrix[i][j];
             }
         }

        System.out.println(rows);
        System.out.println(cols);
        System.out.println(sum);
    }
}
