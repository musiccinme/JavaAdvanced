package SetsAndMapsAdvanced;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class Lab01ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(",\\s+");
        LinkedHashSet<String> parkingLot = new LinkedHashSet<>();

        while (!input[0].equals("END")){
            String direction = input[0];
            String carNumber = input[1];
            if(direction.equals("IN")){
                parkingLot.add(carNumber);
            }else {
                parkingLot.remove(carNumber);
            }
            input = scanner.nextLine().split(",\\s+");
        }

        if(parkingLot.isEmpty()){
            System.out.println("Parking Lot is Empty");
        }else {
            for (String s : parkingLot) {
                System.out.println(s);
            }
        }
    }
}
