package MultidimentionalArrays;

import java.util.Scanner;

public class Ex03DiagonalDifference {
    public static void fillMatrix(Scanner scanner, int[][] matrix, int size){
        for(int row = 0; row < size; row++){
            for(int col = 0; col < size; col++){
                matrix[row][col] = scanner.nextInt();
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[size][size];

        fillMatrix(scanner, matrix, size);

        int sumDiagonal1 = 0;
        int sumDiagonal2 = 0;
        int j = 0;

        for(int i = 0; i < size; i++){
            sumDiagonal1 += matrix[i][i];
        }

        for (int i = size - 1; i >= 0; i--){
            sumDiagonal2 += matrix[i][j];
            j++;
        }

        int difference = Math.abs(sumDiagonal1 - sumDiagonal2);
        System.out.println(difference);


    }
}
