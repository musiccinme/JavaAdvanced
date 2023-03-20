package SetsAndMapsAdvanced;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Lab03VoinaNumberGame {
    private static LinkedHashSet<Integer> getPlayerNumbers(String line){
        return Arrays.stream(line.split(" ")).
                map(Integer::parseInt).collect(Collectors.toCollection(LinkedHashSet::new));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //LinkedHashSet<Integer> firstPlayer = Arrays.stream(scanner.nextLine().split(" ")).
          //      map(Integer::parseInt).collect(Collectors.toCollection(LinkedHashSet::new));
        LinkedHashSet<Integer> firstPlayer = getPlayerNumbers(scanner.nextLine());
        LinkedHashSet<Integer> secondPlayer = getPlayerNumbers(scanner.nextLine());

        for (int i = 0; i < 50; i++){
            int topFirst = firstPlayer.iterator().next();
            firstPlayer.remove(topFirst);
            int topSecond = secondPlayer.iterator().next();
            secondPlayer.remove(topSecond);

            if(topFirst > topSecond){
                firstPlayer.add(topFirst);
                firstPlayer.add(topSecond);
            }else if(topSecond > topFirst){
                secondPlayer.add(topFirst);
                secondPlayer.add(topSecond);
            } else {
                firstPlayer.add(topFirst);
                secondPlayer.add(topSecond);
            }
            if(firstPlayer.isEmpty() || secondPlayer.isEmpty()){
                break;
            }
        }

        if(firstPlayer.size() < secondPlayer.size()){
            System.out.println("Second player win!");
        }else if(secondPlayer.size() < firstPlayer.size()){
            System.out.println("First player win!");
        }else {
            System.out.println("Draw!");
        }
    }
}
