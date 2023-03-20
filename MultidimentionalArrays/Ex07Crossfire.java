package MultidimentionalArrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex07Crossfire {

    public static boolean isInMatrix(int row, int col, List<List<Integer>> matrix){
        return row >= 0 && row < matrix.size() && col >= 0 && col < matrix.get(row).size();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] dimensions = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        List<List<Integer>> matrix = new ArrayList<>();
        int count = 1;

        for (int row = 0; row < rows; row++){
            matrix.add(new ArrayList<>());
            for (int col = 0; col < cols; col++){
                matrix.get(row).add(count);
                count++;
            }
        }

        String[] command = scanner.nextLine().split(" ");

        while (!command[0].equals("Nuke")){
            int rowToNuke = Integer.parseInt(command[0]);
            int colToNuke = Integer.parseInt(command[1]);
            int radius = Integer.parseInt(command[2]);

            for(int row = rowToNuke - radius; row <= rowToNuke +  radius; row++) {
                if (isInMatrix(row, colToNuke, matrix) && row != rowToNuke){
                    matrix.get(row).remove(colToNuke);
                }
            }
            for(int col = colToNuke + radius; col >= colToNuke - radius; col--){
                if(isInMatrix(rowToNuke, col, matrix)){
                    matrix.get(rowToNuke).remove(col);
                }
            }
            matrix.removeIf(List::isEmpty);

            command = scanner.nextLine().split(" ");
        }

        for (List<Integer> list : matrix) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }
}
