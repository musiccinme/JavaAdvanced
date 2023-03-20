package MultidimentionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class Ex09ParkingSystemCorrect {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        boolean[][] parkingLot = new boolean[rows][cols];

        String input = scanner.nextLine();
        while (!input.equals("stop")) {
            int[] directions = Arrays.stream(input.split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();

            int entryRow = directions[0];
            int parkingSpotRow = directions[1];
            int parkingSpotCol = directions[2];

            if (isInBounds(parkingSpotRow, parkingSpotCol, parkingLot)) {

                if (!parkingLot[parkingSpotRow][parkingSpotCol]) {
                    parkingLot[parkingSpotRow][parkingSpotCol] = true;
                    System.out.println(Math.abs(parkingSpotRow - entryRow) + 1 + parkingSpotCol);
                } else {
                    int leftCol = parkingSpotCol - 1;
                    int rightCol = parkingSpotCol + 1;

                    int col = getAvailableColumn(parkingLot, parkingSpotRow, leftCol, rightCol);

                    if (col == -1) {
                        System.out.printf("Row %d full%n", parkingSpotRow);
                    } else {
                        System.out.println(Math.abs(parkingSpotRow - entryRow) + 1 + col);
                    }
                }
            }

            input = scanner.nextLine();
        }
    }

    private static int getAvailableColumn(boolean[][] parkingLot, int parkingSpotRow, int leftCol, int rightCol) {
        while (true) {
            if (!isInBounds(parkingSpotRow, leftCol, parkingLot)
                    && !isInBounds(parkingSpotRow, rightCol, parkingLot)) {
                return -1;
            }

            if (isInBounds(parkingSpotRow, leftCol, parkingLot) && leftCol != 0) {
                if (!parkingLot[parkingSpotRow][leftCol]) {
                    parkingLot[parkingSpotRow][leftCol] = true;
                    return leftCol;
                }
            }

            if (isInBounds(parkingSpotRow, rightCol, parkingLot)) {
                if (!parkingLot[parkingSpotRow][rightCol]) {
                    parkingLot[parkingSpotRow][rightCol] = true;
                    return rightCol;
                }
            }

            leftCol--;
            rightCol++;

        }
    }

    private static boolean isInBounds(int parkingSpotRow, int parkingSpotCol, boolean[][] parkingLot) {
        return parkingSpotRow >= 0 && parkingSpotRow < parkingLot.length &&
                parkingSpotCol > 0 && parkingSpotCol < parkingLot[parkingSpotRow].length;
    }
}
