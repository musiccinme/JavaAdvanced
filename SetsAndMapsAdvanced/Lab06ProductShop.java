package SetsAndMapsAdvanced;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.TreeMap;

public class Lab06ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] info = scanner.nextLine().split(", ");
        TreeMap<String, LinkedHashMap<String, Double>> shopProduct = new TreeMap<>();

        while (!info[0].equals("Revision")){
            String shop = info[0];
            String product = info[1];
            double price = Double.parseDouble(info[2]);
            LinkedHashMap<String, Double> current = new LinkedHashMap<>();
            shopProduct.putIfAbsent(shop, current);
            shopProduct.get(shop).putIfAbsent(product, price);

            info = scanner.nextLine().split(", ");
        }
        shopProduct.forEach((key, value) -> {
            System.out.printf("%s->%n", key);
            value.forEach((key1, value1) ->
                    System.out.printf("Product: %s, Price: %.1f%n", key1, value1)
            );
        });
    }
}
