package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Lab03DecimalToBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int decimal = Integer.parseInt(scanner.nextLine());
        Deque<Integer> binary = new ArrayDeque<>();
        if(decimal == 0){
            binary.push(decimal);
        }else {
            while (decimal > 0) {
                int rest = decimal % 2;
                decimal /= 2;
                binary.push(rest);
            }
        }
        while (!binary.isEmpty()) {
            System.out.print(binary.pop());
        }

    }
}
