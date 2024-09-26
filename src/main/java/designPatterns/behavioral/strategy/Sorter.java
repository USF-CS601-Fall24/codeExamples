package designPatterns.behavioral.strategy;

class Sorter {
    private SortingStrategy sortingStrategy;
    private int[] array;

    Sorter(int[] array) {
        this.array = array.clone();
    }

    void setSortingStrategy(SortingStrategy sortingStrategy) {
        this.sortingStrategy = sortingStrategy;
    }

    public void sort() {
        sortingStrategy.sort(array);
    }
    public void displayArray() {
        System.out.println(java.util.Arrays.toString(array));
    }
}
