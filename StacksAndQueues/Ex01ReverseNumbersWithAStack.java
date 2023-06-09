package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Ex01ReverseNumbersWithAStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (String num : input) {
            stack.push(Integer.parseInt(num));
        }

        while (!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }

    }
}
