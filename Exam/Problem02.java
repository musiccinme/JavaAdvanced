package Exam;

import java.util.*;

public class Problem02 {
    public static boolean isTopEdge(int row){
        return row == -1;
    }

    public static boolean isBottomEdge(int row, String[][] matrix){
        return row == matrix.length;
    }

    public static boolean isLeftEdge(int col){
        return col == -1;
    }

    public static boolean isRightEdge( int col, int size){
        return col == size;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int screenSize = Integer.parseInt(scanner.nextLine());
        int commandCount = Integer.parseInt(scanner.nextLine());

        String[][] matrix = new String[screenSize][screenSize];
        for (int row = 0; row < screenSize; row++){
            matrix[row] = scanner.nextLine().split("");
        }

        int startRow = 0;
        int startCol = 0;

        for(int row = 0; row < screenSize; row++){
            for (int col = 0; col < screenSize; col++){
                if (matrix[row][col].equals("P")){
                    startRow = row;
                    startCol = col;
                }
            }
        }

        boolean hasNotFinished = true;
        while (hasNotFinished && commandCount > 0){

            String command = scanner.nextLine();
            commandCount--;

            int currentRow = 0;
            int currentCol = 0;

            switch (command){
                case "up":
                    currentRow = startRow - 1;
                    if(isTopEdge(currentRow)){
                        currentRow = matrix.length - 1;
                    }
                    currentCol = startCol;
                    matrix[startRow][startCol] = ".";
                    if(matrix[currentRow][currentCol].equals("T")){
                        currentRow = startRow;
                    }else if(matrix[currentRow][currentCol].equals("B")){
                        currentRow = currentRow - 1;
                        if(isTopEdge(currentRow)){
                            currentRow = matrix.length - 1;
                        }
                    }
                    if(matrix[currentRow][currentCol].equals("F")){
                        matrix[currentRow][currentCol] = "P";
                        hasNotFinished = false;
                        break;
                    }
                    matrix[currentRow][currentCol] = "P";
                    startRow = currentRow;
                    startCol = currentCol;
                    break;

                case "down":
                    currentRow = startRow + 1;
                    if(isBottomEdge(currentRow, matrix)){
                        currentRow = 0;
                    }
                    currentCol = startCol;
                    matrix[startRow][startCol] = ".";
                    if(matrix[currentRow][currentCol].equals("T")){
                        currentRow = startRow;
                    }else if(matrix[currentRow][currentCol].equals("B")){
                        currentRow = currentRow + 1;
                        if(isTopEdge(currentRow)){
                            currentRow = 0;
                        }
                    }
                    if(matrix[currentRow][currentCol].equals("F")){
                        matrix[currentRow][currentCol] = "P";
                        hasNotFinished = false;
                        break;
                    }
                    matrix[currentRow][currentCol] = "P";
                    startRow = currentRow;
                    startCol = currentCol;
                    break;

                case "left":
                    currentCol = startCol - 1;
                    if(isLeftEdge(currentCol)){
                        currentCol = screenSize - 1;
                    }
                    currentRow = startRow;
                    matrix[startRow][startCol] = ".";
                    if(matrix[currentRow][currentCol].equals("T")){
                        currentCol = startCol;
                    }else if(matrix[currentRow][currentCol].equals("B")){
                        currentCol = currentCol - 1;
                        if(isLeftEdge(currentCol)){
                            currentCol = screenSize - 1;
                        }
                    }
                    if(matrix[currentRow][currentCol].equals("F")){
                        matrix[currentRow][currentCol] = "P";
                        hasNotFinished = false;
                        break;
                    }
                    matrix[currentRow][currentCol] = "P";
                    startRow = currentRow;
                    startCol = currentCol;
                    break;

                case "right":
                    currentCol = startCol + 1;
                    if(isRightEdge(currentCol, screenSize)){
                        currentCol = 0;
                    }
                    currentRow = startRow;
                    matrix[startRow][startCol] = ".";
                    if(matrix[currentRow][currentCol].equals("T")){
                        currentCol = startCol;
                    }else if(matrix[currentRow][currentCol].equals("B")){
                        currentCol = currentCol + 1;
                        if(isRightEdge(currentCol, screenSize)){
                            currentCol = 0;
                        }
                    }
                    if(matrix[currentRow][currentCol].equals("F")){
                        matrix[currentRow][currentCol] = "P";
                        hasNotFinished = false;
                        break;
                    }
                    matrix[currentRow][currentCol] = "P";
                    startRow = currentRow;
                    startCol = currentCol;
                    break;
            }

        }
        if(!hasNotFinished){
            System.out.println("Well done, the player won first place!");
        } else {
            System.out.println("Oh no, the player got lost on the track!");
        }

        for (String[] strings : matrix) {
            System.out.println((Arrays.toString(strings).replaceAll("[\\[\\],]", "").replaceAll("\\s+", "")));
        }

    }
}
