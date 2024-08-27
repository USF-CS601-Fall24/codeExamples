package dataStructures;

import java.util.SortedMap;
import java.util.TreeMap;

public class TreeMapExample {
    public static void main(String[] args) {
        TreeMap<String, String> sortedMap = new TreeMap<>();
        sortedMap.put("1", "uno");
        sortedMap.put("2", "dos");
        sortedMap.put("3", "tres");
        sortedMap.put("4", "cuantro");
        System.out.println(sortedMap);
        System.out.println(sortedMap.subMap("2", "4"));

    }
}
