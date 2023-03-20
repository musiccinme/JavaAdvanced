package MultidimentionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class Ex02MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        String[][] matrix = new String[rows][cols];

        char startLetter = 'a';

        for(int row = 0; row < rows; row++){
            for (int col = 0; col < cols; col++){
                String palindrome = "" + startLetter + (char)(startLetter + col) + startLetter;
                matrix[row][col] = palindrome;
            }
            startLetter = (char)(startLetter + 1);
        }

        for (String[] row : matrix) {
            System.out.println(Arrays.toString(row).replaceAll("[\\[\\],]", "").replaceAll("\\s+", " "));
        }
    }
}
