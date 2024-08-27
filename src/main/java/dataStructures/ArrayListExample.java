package dataStructures;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListExample {
    public static void main(String[] args) {
        /*
        ArrayList<String> countries = new ArrayList<>();
        countries.add("USA");
        countries.add("China");
        countries.add("Italy");

        System.out.println(countries);

        for (int i = 0; i < countries.size(); i++) {
            System.out.print(countries.get(i) + " ");
        }
        System.out.println();

        for (String country: countries) {
            System.out.println(country);
        }
        Collections.sort(countries);
        System.out.println(countries);

        countries.forEach(System.out::println); // Will discuss late
        */

        ArrayList<BankAccount> accounts = new ArrayList<>();
        accounts.add(new BankAccount(300, "Jones"));
        accounts.add(new BankAccount(20, "Smith"));
        System.out.println(accounts);

    }
}
