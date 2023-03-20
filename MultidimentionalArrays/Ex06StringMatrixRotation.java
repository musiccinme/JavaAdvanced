package MultidimentionalArrays;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class Ex06StringMatrixRotation {

    public static void rotate90(String[][] matrix, int maxLength){

        for(int i = 0; i < maxLength; i++){
            for (int j = matrix.length-1; j >= 0; j--){
                try {
                    System.out.print(matrix[j][i]);
                }catch (ArrayIndexOutOfBoundsException e){
                    System.out.print(" ");
                }
            }
            System.out.println();

        }
    }

    public static void rotate180(String[][] matrix, int maxLength){

        for(int i = matrix.length-1; i >= 0; i--){
            for (int j = maxLength-1; j >= 0; j--){
                try {
                    System.out.print(matrix[i][j]);
                }catch (ArrayIndexOutOfBoundsException e){
                    System.out.print(" ");
                }
            }
            System.out.println();

        }
    }

    public static void rotate270(String[][] matrix, int maxLength){

        for(int i = maxLength - 1; i >= 0; i--){
            for (int j = 0; j < matrix.length; j++){
                try {
                    System.out.print(matrix[j][i]);
                }catch (ArrayIndexOutOfBoundsException e){
                    System.out.print(" ");
                }
            }
            System.out.println();

        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] command = scanner.nextLine().split("[()]+");

        int degrees = Integer.parseInt(command[1]) % 360;

        Deque<String[]> matrixLines = new ArrayDeque<>();
        int counter = 0;
        String toOffer = scanner.nextLine();
        while (!toOffer.equals("END")) {
            matrixLines.offer(toOffer.split(""));
            counter++;
            toOffer = scanner.nextLine();
        }

        String[][] matrix = new String[counter][];

        int maxLength = 0;
        for(int i = 0; i < counter; i++){
            matrix[i] = matrixLines.poll();
            int curr = matrix[i].length;
            maxLength = Math.max(maxLength, curr);
        }
        if(degrees == 90){
            rotate90(matrix, maxLength);
        }else if(degrees == 180){
            rotate180(matrix, maxLength);
        }else if (degrees == 270){
            rotate270(matrix, maxLength);
        }else {
            for (String[] strings : matrix) {
                System.out.println(Arrays.toString(strings).replaceAll("[\\[\\], ]", "").replaceAll("\\s+", " "));
            }
        }


    }
}
