package MultidimentionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class Ex05MatrixShuffle {
    public static boolean isValid(String[] command, int rows, int cols){
        if(command.length != 5){
            return false;
        }
        if(!command[0].equals("swap")){
            return false;
        }

        int row1 = Integer.parseInt(command[1]);
        int col1 = Integer.parseInt(command[2]);
        int row2 = Integer.parseInt(command[3]);
        int col2 = Integer.parseInt(command[4]);

        if(row1 >= rows || row2 >= rows || col1 >= cols || col2 >= cols){
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];
        String[][] matrix = new String[rows][];

        for (int i = 0; i < rows; i++){
            matrix[i] = scanner.nextLine().split(" ");
        }

        String[] command = scanner.nextLine().split(" ");

        while (!command[0].equals("END")){
            if(!isValid(command, rows, cols)){
                System.out.println("Invalid input!");
            }else {
                int row1 = Integer.parseInt(command[1]);
                int col1 = Integer.parseInt(command[2]);
                int row2 = Integer.parseInt(command[3]);
                int col2 = Integer.parseInt(command[4]);

                String coord1 = matrix[row1][col1];
                String coord2 = matrix[row2][col2];

                matrix[row1][col1] = coord2;
                matrix[row2][col2] = coord1;

                for (String[] strings : matrix) {
                    System.out.println(Arrays.toString(strings).replaceAll("[\\[\\],]", "").replaceAll("\\s+", " "));
                }
            }

            command = scanner.nextLine().split(" ");
        }
    }
}
