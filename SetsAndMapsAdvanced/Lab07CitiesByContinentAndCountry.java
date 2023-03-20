package SetsAndMapsAdvanced;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Lab07CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, LinkedHashMap<String, ArrayList<String>>> continentCountryCities
                = new LinkedHashMap<>();
        int n = Integer.parseInt(scanner.nextLine());

        while (n > 0){
            String[] info = scanner.nextLine().split(" ");
            String continent = info[0];
            String country = info[1];
            String city = info[2];
            continentCountryCities.putIfAbsent(continent, new LinkedHashMap<>());
            continentCountryCities.get(continent).putIfAbsent(country, new ArrayList<>());
            continentCountryCities.get(continent).get(country).add(city);
            n--;
        }
        continentCountryCities.forEach((continent, country) -> {
            System.out.printf("%s:%n", continent);
            country.forEach((country1, city) -> {
                System.out.printf("  %s -> ", country1);
                System.out.println(String.join(", ", city));
                /*city.forEach((city1)->
                                System.out.printf("")
                        ); */
            });
        });
    }
}
