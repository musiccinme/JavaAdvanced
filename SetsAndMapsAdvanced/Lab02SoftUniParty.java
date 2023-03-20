package SetsAndMapsAdvanced;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class Lab02SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        TreeSet<String> vip = new TreeSet<>();
        TreeSet<String> regular = new TreeSet<>();

        while(!input.equals("PARTY")){
            char first = input.charAt(0);
            if(Character.isDigit(first)){
                vip.add(input);
            }else {
                regular.add(input);
            }
            input = scanner.nextLine();
        }
        input = scanner.nextLine();
        while (!input.equals("END")){
            if(vip.contains(input)){
                vip.remove(input);
            }else if(regular.contains(input)){
                regular.remove(input);
            }
            input = scanner.nextLine();
        }
        System.out.println(vip.size() + regular.size());
        for (String s : vip) {
            System.out.println(s);
        }
        for (String s : regular) {
            System.out.println(s);
        }
    }
}
