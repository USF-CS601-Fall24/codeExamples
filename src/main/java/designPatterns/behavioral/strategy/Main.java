package designPatterns.behavioral.strategy;

public class Main {
    public static void main(String[] args) {
        int[] arr = {9, 3, 5, 1, 7};
        Sorter sorter = new Sorter(arr);
        sorter.setSortingStrategy(new MergeSort());
        sorter.sort();
        sorter.displayArray();
    }
}
