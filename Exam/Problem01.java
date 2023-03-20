package Exam;

import java.util.Scanner;
import java.util.*;

public class Problem01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<Integer> liquidQueue = new ArrayDeque<>();
        Deque<Integer> ingredientStack = new ArrayDeque<>();
        Map<String, Integer> pastries = new TreeMap<>();

        String[] inputQueue = scanner.nextLine().split(" ");

        for (String number : inputQueue) {
            liquidQueue.add(Integer.parseInt(number));
        }

        String[] inputStack = scanner.nextLine().split(" ");

        for (String num : inputStack) {
            ingredientStack.push(Integer.parseInt(num));
        }

        while (liquidQueue.size() != 0 && ingredientStack.size() != 0){
            int currentIngredient = ingredientStack.pop();
            int currentLiquid = liquidQueue.poll();
            int sum = currentIngredient + currentLiquid;

            if(sum == 25){
                pastries.putIfAbsent("Biscuit", 0);
                pastries.put("Biscuit", pastries.get("Biscuit") + 1);
            }else if(sum == 50){
                pastries.putIfAbsent("Cake", 0);
                pastries.put("Cake", pastries.get("Cake") + 1);
            }else if(sum == 75){
                pastries.putIfAbsent("Pastry", 0);
                pastries.put("Pastry", pastries.get("Pastry") + 1);
            }else if(sum == 100){
                pastries.putIfAbsent("Pie", 0);
                pastries.put("Pie", pastries.get("Pie") + 1);
            }else {
                currentIngredient = currentIngredient + 3;
                ingredientStack.push(currentIngredient);
            }

        }

        if(pastries.size() == 4){
            System.out.println("Great! You succeeded in cooking all the food!");
        }else {
            System.out.println("What a pity! You didn't have enough materials to cook everything.");
        }
        if(liquidQueue.size() > 0){
            System.out.print("Liquids left: ");
            while (liquidQueue.size() != 1){
                System.out.print(liquidQueue.poll() + ", ");
            }
            System.out.print(liquidQueue.poll());
            System.out.println();
        }else {
            System.out.println("Liquids left: none");
        }
        if(ingredientStack.size() > 0){
            System.out.print("Ingredients left: ");
            while (ingredientStack.size() != 1){
                System.out.print(ingredientStack.pop() + ", ");
            }
            System.out.print(ingredientStack.pop());
            System.out.println();
        } else {
            System.out.println("Ingredients left: none");
        }

        /*for (Map.Entry<String, Integer> pastry : pastries.entrySet()) {
            System.out.printf("%s: %d%n", pastry.getKey(), pastry.getValue());
        }*/

        pastries.putIfAbsent("Biscuit", 0);
        pastries.putIfAbsent("Cake", 0);
        pastries.putIfAbsent("Pastry", 0);
        pastries.putIfAbsent("Pie", 0);

        System.out.printf("Biscuit: %d%n", pastries.get("Biscuit"));
        System.out.printf("Cake: %d%n", pastries.get("Cake"));
        System.out.printf("Pie: %d%n", pastries.get("Pie"));
        System.out.printf("Pastry: %d%n", pastries.get("Pastry"));

    }
}
