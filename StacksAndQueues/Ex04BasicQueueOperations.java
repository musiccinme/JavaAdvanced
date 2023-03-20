package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class Ex04BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int s = Integer.parseInt(input[1]);
        int x = Integer.parseInt(input[2]);

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        String[] numbers = scanner.nextLine().split(" ");

        for (String number : numbers) {
            queue.add(Integer.parseInt(number));
        }

        for (int i = 1; i <= s; i++){
            queue.remove();
        }

        if(queue.contains(x)){
            System.out.println("true");
        } else {
            if(!queue.isEmpty()){
                System.out.println(Collections.min(queue));
            }else {
                System.out.println(0);
            }
        }
    }
}
