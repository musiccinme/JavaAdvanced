package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Lab07MathPotato {
    public static boolean isPrime(int n){
        boolean isItPrime = true;
        if(n == 1){
            isItPrime = false;
            return isItPrime;
        }else {
            for (int i = 2; i < n; i++) {
                if (n % i == 0) {
                    isItPrime = false;
                    break;
                }
            }
            return isItPrime;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] children = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(scanner.nextLine());
        Deque<String> queue = new ArrayDeque<>();

        for (String child : children) {
            queue.offer(child);
        }

        int count = 1;
        while (queue.size() > 1) {
            for (int i = 1; i< n; i++){
                queue.offer(queue.poll());
            }
            if(isPrime(count)){
                System.out.println("Prime " + queue.peek());
            }else {
                System.out.println("Removed " + queue.poll());
            }
            count++;
        }
        System.out.println("Last is " + queue.poll());
    }
}
