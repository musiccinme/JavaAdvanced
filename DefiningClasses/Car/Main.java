package DefiningClasses.Car;

import DefiningClasses.Car.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Car> cars = new ArrayList<>();


        while (n > 0){
            String[] input = scanner.nextLine().split("\\s+");
            Car car;
            if(input.length == 1) {
                car = new Car(input[0]);
                //System.out.println(car.carInfo());
            }else {
                car = new Car(input[0], input[1], Integer.parseInt(input[2]));
                //System.out.println(car.carInfo());
            }
            cars.add(car);
            n--;
        }

        System.out.println(cars
                .stream()
                .map(Car::toString)
                .collect(Collectors.joining(System.lineSeparator()))); 

    }
}
