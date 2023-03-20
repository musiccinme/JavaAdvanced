package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class Lab02SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> expression = new ArrayDeque<>();

        String[] tokens = scanner.nextLine().split("\\s+");
        Collections.addAll(expression, tokens);

        while (expression.size() > 1){
            int first = Integer.parseInt(expression.pop());
            String op = expression.pop();
            int second = Integer.parseInt(expression.pop());

            if(op.equals("+")){
                expression.push(String.valueOf(first + second));
            }
            else if(op.equals("-")){
                expression.push(String.valueOf(first - second));
            }
        }
        System.out.println(expression.pop());
    }
}
