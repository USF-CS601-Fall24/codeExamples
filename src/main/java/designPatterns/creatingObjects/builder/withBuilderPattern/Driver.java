package designPatterns.creatingObjects.builder.withBuilderPattern;

/** Driver class for the Builder Pattern */
public class Driver {
    public static void main(String[] args) {
        NutritionFacts.Builder builder = new NutritionFacts.Builder(20, 8);
        NutritionFacts nf = builder.calories(300).fat(10).build();
        System.out.println(nf);
    }

}
