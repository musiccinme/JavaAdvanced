package MultidimentionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class Lab05MaximumSumOf2x2Submatrix {

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

        int maxSum = 0;
        int[][] subMatrix = new int[2][2];

        for (int i = 0; i < matrix.length - 1; i++){
            for(int j = 0; j < matrix[i].length - 1; j++){
                int currentSum = matrix[i][j] + matrix[i][j+1] + matrix[i+1][j] + matrix[i+1][j+1];
                if(currentSum > maxSum){
                    subMatrix[0][0] = matrix[i][j];
                    subMatrix[0][1] = matrix[i][j+1];
                    subMatrix[1][0] = matrix[i+1][j];
                    subMatrix[1][1] = matrix[i+1][j+1];
                    maxSum = currentSum;
                }
            }
        }

        for (int[] ints : subMatrix) {
            System.out.println(Arrays.toString(ints).replaceAll("[\\[\\],]", "").replaceAll("\\s+", " "));
        }
        System.out.println(maxSum);
    }
}

