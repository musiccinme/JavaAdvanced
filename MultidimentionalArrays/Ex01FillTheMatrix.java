package MultidimentionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class Ex01FillTheMatrix {

    public static int[][] patternA(int size, String type){
        int[][] matrix = new int[size][size];

        int initialisation = 1;
        for(int cols = 0; cols < size; cols++){
            for (int rows = 0; rows < size; rows++){
                matrix[rows][cols] = initialisation;
                initialisation++;
            }
        }

        return matrix;
    }

    public static int[][] patternB(int size, String type){
        int[][] matrix = new int[size][size];

        int initialisation = 1;
        for(int cols = 0; cols < size; cols++){
            if(cols % 2 == 0) {
                for (int rows = 0; rows < size; rows++) {
                    matrix[rows][cols] = initialisation;
                    initialisation++;
                }
            }else {
                for (int rows = size-1; rows >= 0; rows--) {
                    matrix[rows][cols] = initialisation;
                    initialisation++;
                }
            }
        }

        return matrix;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");

        int matrixSize = Integer.parseInt(input[0]);
        String matrixPattern = input[1];

        int[][] matrix;
        if(matrixPattern.equals("A")){
            matrix = patternA(matrixSize, matrixPattern);
        }else {
            matrix = patternB(matrixSize, matrixPattern);
        }

        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints).replaceAll("[\\[\\],]", "").replaceAll("\\s+", " "));
        }

    }
}
