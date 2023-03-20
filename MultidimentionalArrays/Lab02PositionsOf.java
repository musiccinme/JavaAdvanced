package MultidimentionalArrays;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Lab02PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] matrix = new int[rows][];

        for(int row = 0; row <rows; row++){
            int[] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();

            matrix [row] = arr;
        }

        int n = Integer.parseInt(scanner.nextLine());
        int count = 0;

        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++){
                if(matrix[i][j] == n){
                    System.out.printf("%d %d%n", i, j);
                    count++;
                }
            }
        }
        if(count == 0){
            System.out.println("not found");
        }
    }
}
