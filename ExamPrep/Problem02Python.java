package ExamPrep;


import java.util.Scanner;

public class Problem02Python {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int screenSize = Integer.parseInt(scanner.nextLine());
        String[] commands = scanner.nextLine().split(", ");

        String[][] screen = new String[screenSize][screenSize];
        for (int row = 0; row < screenSize; row++){
            screen[row] = scanner.nextLine().split(" ");
        }

        int currentRow = 0;
        int currentCol = 0;
        int foodCount = 0;

        for(int row = 0; row < screenSize; row++){
            for (int col = 0; col < screenSize; col++){
                if (screen[row][col].equals("s")){
                    currentRow = row;
                    currentCol = col;
                }else if(screen[row][col].equals("f")){
                    foodCount++;
                }
            }
        }
        int startRow = currentRow;
        int startCol = currentCol;

        int count = 0;
        int pythonSize = 1;
        boolean gotKilled = false;


        while (count < commands.length){
            switch (commands[count]){
                case "up":
                    if(isTopEdge(currentRow-1)){
                        currentRow = screenSize - 1;
                    }else {
                        currentRow = currentRow - 1;}
                    if(screen[currentRow][currentCol].equals("e")){
                        gotKilled = true;
                        break;
                    }else if(screen[currentRow][currentCol].equals("f")){
                        screen[currentRow][currentCol] = "*";
                        pythonSize++;
                        foodCount--;
                    }
                    break;

                case "down":
                    if(isBottomEdge(currentRow+1, screen)){
                        currentRow = 0;
                    }
                    else {
                        currentRow = currentRow + 1;}
                    if(screen[currentRow][currentCol].equals("e")){
                        gotKilled = true;
                        break;
                    }else if(screen[currentRow][currentCol].equals("f")){
                        screen[currentRow][currentCol] = "*";
                        pythonSize++;
                        foodCount--;
                    }
                    break;

                case "left":
                    if(isLeftEdge(currentCol-1)){
                        currentCol = screenSize - 1;
                    }else {
                        currentCol = currentCol - 1;}
                    if(screen[currentRow][currentCol].equals("e")){
                        gotKilled = true;
                        break;
                    }else if(screen[currentRow][currentCol].equals("f")){
                        screen[currentRow][currentCol] = "*";
                        pythonSize++;
                        foodCount--;
                    }
                    break;

                case "right":
                    if(isRightEdge(currentRow, currentCol+1, screen)){
                        currentCol = 0;
                    }else {
                        currentCol = currentCol + 1; }
                    if(screen[currentRow][currentCol].equals("e")){
                        gotKilled = true;
                        break;
                    }else if(screen[currentRow][currentCol].equals("f")){
                        screen[currentRow][currentCol] = "*";
                        pythonSize++;
                        foodCount--;
                    }
                    break;
            }
            if(foodCount == 0){
                break;
            }
            count++;
        }
        screen[startRow][startCol] = "*";
        if(gotKilled) {
            System.out.println("You lose! Killed by an enemy!");
        }else if(foodCount == 0){
            System.out.printf("You win! Final python length is %d%n", pythonSize);
        }else if(foodCount > 0){
            System.out.printf("You lose! There is still %d food to be eaten.%n", foodCount);
        }
    }

    public static boolean isTopEdge(int row){
        return row == -1;
    }

    public static boolean isBottomEdge(int row, String[][] matrix){
        return row == matrix.length;
    }

    public static boolean isLeftEdge(int col){
        return col == -1;
    }

    public static boolean isRightEdge(int row, int col, String[][] matrix){
        return col == matrix[row].length;
    }
}
