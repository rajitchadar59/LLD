public class BuilderWithoutPatternPizza {

    private String size;
    private boolean cheese;
    private boolean pepperoni;
    private boolean bacon;
    private boolean mushrooms;

    public BuilderWithoutPatternPizza(String size,
                               boolean cheese,
                               boolean pepperoni,
                               boolean bacon,
                               boolean mushrooms) {

        this.size = size;
        this.cheese = cheese;
        this.pepperoni = pepperoni;
        this.bacon = bacon;
        this.mushrooms = mushrooms;
    }

    public void display() {
        System.out.println("Size: " + size);
        System.out.println("Cheese: " + cheese);
        System.out.println("Pepperoni: " + pepperoni);
        System.out.println("Bacon: " + bacon);
        System.out.println("Mushrooms: " + mushrooms);
    }

    public static void main(String[] args) {

        BuilderWithoutPatternPizza pizza =
                new BuilderWithoutPatternPizza(
                        "Large",
                        true,
                        true,
                        false,
                        true
                );

        pizza.display();
    }
}