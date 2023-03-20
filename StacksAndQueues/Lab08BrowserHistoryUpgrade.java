package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Lab08BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> browser = new ArrayDeque<>();
        ArrayDeque<String> forward = new ArrayDeque<>();
        String line = scanner.nextLine();
        String current = "";

        while (!line.equals("Home")){
            if (line.equals("back")){
                if(!browser.isEmpty()){
                    forward.addFirst(current);
                    current = browser.pop();
                } else {
                    System.out.println("no previous URLs");
                    line = scanner.nextLine();
                    continue;
                }
            } else if(line.equals("forward")){
                if(!forward.isEmpty()){
                    current = forward.poll();
                }else {
                    System.out.println("no next URLs");
                    line = scanner.nextLine();
                    continue;
                }
            }
            else {
                if(!current.equals("")){
                    browser.push(current);
                    forward.clear();
                }
                current = line;
            }
            System.out.println(current);
            line = scanner.nextLine();
        }
    }
}
