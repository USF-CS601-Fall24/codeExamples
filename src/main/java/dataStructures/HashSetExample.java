package dataStructures;

import java.util.HashSet;
import java.util.TreeSet;

public class HashSetExample {
    public static void main(String[] args) {
        HashSet<String> words = new HashSet<>();
        words.add("cat");
        words.add("mail");
        words.add("dog");
        words.add("cat"); // won't add it again
        System.out.println(words); //don’t know the order

       TreeSet<String> wordsTree = new TreeSet<>();
       wordsTree.add("house");
       wordsTree.add("cat");
       wordsTree.add("mail");
       wordsTree.add("dog");
       String firstElement = wordsTree.first();
       System.out.println(firstElement);
       String test = wordsTree.lower("mail");
       System.out.println(test);

        // Would not work because we need to tell Java how to compare BankAccounts
        /*
        TreeSet<BankAccount> setb = new TreeSet<>();
        setb.add(new BankAccount(50, "Jones"));
        setb.add(new BankAccount(150, "SJones"));
         */

    }
}
