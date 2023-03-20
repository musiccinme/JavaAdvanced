package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Ex08SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> text = new ArrayDeque<>();
        String current = "";
        text.push(current);

        int n = Integer.parseInt(scanner.nextLine());
        String[] input;


        while (n>0){
            input = scanner.nextLine().split(" ");
            switch (input[0]){
                case "1":
                    current = current + input[1];
                    text.push(current);
                    break;
                case "2":
                    int count = Integer.parseInt(input[1]);
                    current = current.substring(0, current.length()-count);
                    text.push(current);
                    break;
                case "3":
                    int index = Integer.parseInt(input[1]);
                    System.out.println(current.charAt(index-1));
                    break;
                case "4":
                    text.pop();
                    current = text.peek();
                    break;
            }

            n--;
        }
    }
}
