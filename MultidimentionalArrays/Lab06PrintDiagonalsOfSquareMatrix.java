package MultidimentionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class Lab06PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[n][];

        for (int i = 0; i < matrix.length; i++){
            int[] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
            matrix[i] = arr;
        }

        for (int i = 0; i < matrix.length; i++){
            System.out.print(matrix[i][i] + " ");
        }
        System.out.println();

        int j = n-1;
        for (int i = 0; i < matrix.length; i++){
            System.out.print(matrix[j][i] + " ");
            j--;
        }

    }
}
