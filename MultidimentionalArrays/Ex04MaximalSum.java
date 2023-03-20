package MultidimentionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class Ex04MaximalSum {

    public static void fillMatrix(Scanner scanner, int[][] matrix, int rows, int cols){
        for(int row = 0; row < rows; row++){
            for(int col = 0; col < cols; col++){
                matrix[row][col] = scanner.nextInt();
            }
        }
    }

    public static int sum(int[][] matrix, int rowStart, int colStart){
        int sum = 0;
        for(int i = rowStart; i <= rowStart + 2; i++){
            for (int j = colStart; j <= colStart + 2; j++){
                sum += matrix[i][j];

            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];
        int[][] matrix = new int[rows][cols];

        fillMatrix(scanner, matrix, rows, cols);

        int[][] subMatrix = new int[3][3];
        int sumMax = 0;
        int currentSum = 0;
        int indexRowStart = 0;
        int indexColStart = 0;

        for (int i = 0; i <= rows - 3; i++){
            for (int j = 0; j <= cols - 3; j++){
                currentSum = sum(matrix, i, j);

                if(currentSum > sumMax){
                    sumMax = currentSum;
                    indexRowStart = i;
                    indexColStart = j;
                }
            }
        }

        int c = 0;
        int r = 0;

        for (int i = indexRowStart; i <= indexRowStart + 2; i++){
            for (int j = indexColStart; j <= indexColStart + 2; j++){
                subMatrix[r][c] = matrix[i][j];
                c++;
            }
            c = 0;
            r++;

        }

        System.out.println("Sum = " + sumMax);
        for (int[] ints : subMatrix) {
            System.out.println((Arrays.toString(ints).replaceAll("[\\[\\],]", "").replaceAll("\\s+", " ")));
        }
    }
}
