package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Ex06BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("");

        boolean areBalanced = false;
        ArrayDeque<String> stack = new ArrayDeque<>();
        for (String s : input) {
            if(s.equals("{")||s.equals("[")||s.equals("(")){
                stack.push(s);
            }else {
                if(!stack.isEmpty()){
                    String lastInStack = stack.pop();
                    if(s.equals("}") && lastInStack.equals("{")){
                        areBalanced = true;
                    }else if(s.equals(")") && lastInStack.equals("(")){
                        areBalanced = true;
                    }else if(s.equals("]") && lastInStack.equals("[")) {
                        areBalanced = true;
                    }else {
                        areBalanced = false;
                        break;
                    }
                }else {
                    areBalanced = false;
                }
            }

        }

        if(areBalanced){
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }
    }
}
