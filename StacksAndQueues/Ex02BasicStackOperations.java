package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class Ex02BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int s = Integer.parseInt(input[1]);
        int x = Integer.parseInt(input[2]);

        String[] numbers = scanner.nextLine().split(" ");
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (String number : numbers) {
            stack.push(Integer.parseInt(number));
        }

        for (int i = 1; i <= s; i++){
            stack.pop();
        }

        if(stack.contains(x)){
            System.out.println("true");
        } else {
            if(!stack.isEmpty()){
                System.out.println(Collections.min(stack));
            }else {
                System.out.println(0);
            }
        }
    }
}
