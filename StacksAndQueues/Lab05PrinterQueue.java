package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Lab05PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Deque<String> queue = new ArrayDeque<>();

        while (!input.equals("print")){

            if(input.equals("cancel")){
                if(queue.isEmpty()){
                    System.out.println("Printer is on standby");
                } else {
                    System.out.println("Canceled " + queue.pollFirst());
                    //queue.pollFirst();
                }
            }else {
                queue.offer(input);
            }
            input = scanner.nextLine();
        }
        if (!queue.isEmpty()) {
            for (String s : queue) {
                System.out.println(s);
            }
        }
    }
}
