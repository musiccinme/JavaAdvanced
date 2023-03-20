package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class Ex03MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        ArrayDeque <Integer> stack = new ArrayDeque<>();

         while (n>0){
             String[] command = scanner.nextLine().split(" ");

             switch (command[0]){
                 case "1":
                     stack.push(Integer.parseInt(command[1]));
                     break;
                 case "2":
                     stack.pop();
                     break;
                 case "3":
                     System.out.println(Collections.max(stack));
                     break;
             }

             n--;
         }
    }
}
