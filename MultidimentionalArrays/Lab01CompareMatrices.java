package MultidimentionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class Lab01CompareMatrices {

    public static boolean isEqual(int[][] first, int[][] second) {
        if (first.length != second.length){
            return false;
        }else {
            for (int row = 0; row < first.length; row++) {
                if (first[row].length != second[row].length) {
                    return false;
                } else {
                    for (int cols = 0; cols < first[row].length; cols++) {
                        if (first[row][cols] != second[row][cols]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+")).
                mapToInt(Integer::parseInt).toArray();
        int firstMatrixRows = dimensions[0];
        int firstMatrixCols = dimensions[1];

        int[][] firstMatrix = new int[firstMatrixRows][];

        for (int i = 0; i < firstMatrixRows; i++){
            int[] arr = Arrays.stream(scanner.nextLine().split("\\s+")).
                    mapToInt(Integer::parseInt).toArray();
            firstMatrix[i] = arr;
        }

        dimensions = Arrays.stream(scanner.nextLine().split("\\s+")).
                mapToInt(Integer::parseInt).toArray();

        int secondMatrixRows = dimensions[0];
        int secondMatrixCols = dimensions[1];

        int[][] secondMatrix = new int[secondMatrixRows][];

        for (int i = 0; i < secondMatrixRows; i++){
            int[] arr = Arrays.stream(scanner.nextLine().split("\\s+")).
                    mapToInt(Integer::parseInt).toArray();
            secondMatrix[i] = arr;
        }

        if (isEqual(firstMatrix, secondMatrix)){
            System.out.println("equal");
        }else {
            System.out.println("not equal");
        }

    }
}
