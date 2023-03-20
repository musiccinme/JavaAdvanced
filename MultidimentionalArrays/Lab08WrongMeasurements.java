package MultidimentionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class Lab08WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[rows][];

        for (int i = 0; i < matrix.length; i++){
            int[] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
            matrix[i] = arr;
        }

        int[] wrongElemPosition = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int wrongRow = wrongElemPosition[0];
        int wrongCol = wrongElemPosition[1];

        int wrongElem = matrix[wrongRow][wrongCol];
        int[][] rightMatrix = new int[rows][matrix[rows-1].length];


        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++){
                if (matrix[i][j] == wrongElem){
                    int sum = 0;

                    if(i >= 1 && matrix[i-1][j] != wrongElem){
                        sum += matrix[i-1][j];
                    }
                    if(i < rows-1 && matrix[i+1][j] != wrongElem){
                        sum += matrix[i+1][j];
                    }
                    if(j >= 1 && matrix[i][j-1] != wrongElem ){
                        sum += matrix[i][j-1];
                    }
                    if(j < matrix[i].length - 1 && matrix[i][j+1] != wrongElem){
                        sum += matrix[i][j+1];
                    }
                    rightMatrix[i][j] = sum;
                }else {
                    rightMatrix[i][j] = matrix[i][j];
                }
            }
        }
        for (int[] ints : rightMatrix) {
            System.out.println(Arrays.toString(ints).replaceAll("[\\[\\],]", "")
                    .replaceAll("\\s+", " "));
        }

    }
}
