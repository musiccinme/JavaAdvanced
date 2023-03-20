package MultidimentionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class Lab03IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        String[][] a = new String[rows][];
        String[][] b = new String[rows][];
        String[][] c = new String[rows][cols];

        for (int row = 0; row < a.length; row++){
            String[] text = scanner.nextLine().split("\\s+");
            a[row] = text;
        }

        for (int row = 0; row < b.length; row++){
            String[] text = scanner.nextLine().split("\\s+");
            b[row] = text;
        }

        for (int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(a[i][j].equals(b[i][j])){
                    c[i][j] = a[i][j];
                }else {
                    c[i][j] = "*";
                }
            }
        }

        for (String[] strings : c) {
            System.out.println((Arrays.toString(strings).replaceAll("[\\[\\],]", "").replaceAll("\\s+", " ")));
        }


    }
}
