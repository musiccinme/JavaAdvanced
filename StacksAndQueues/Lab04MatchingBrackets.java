package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Lab04MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < expression.length(); i++) {
            char current = expression.charAt(i);
            if(current == '('){
                stack.push(i);
            }else if (current == ')'){
                int openingBracket = stack.pop();
                String subexpression = expression.substring(openingBracket, i+1);
                System.out.println(subexpression);
            }

        }
    }
}
