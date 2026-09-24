public class BuilderWithPatternPizza {

    private String size;
    private boolean cheese;
    private boolean pepperoni;
    private boolean bacon;
    private boolean mushrooms;

    public BuilderWithPatternPizza(Builder b) {
        this.size = b.size;
        this.cheese = b.cheese;
        this.pepperoni = b.pepperoni;
        this.bacon = b.bacon;
        this.mushrooms = b.mushrooms;
    }

    public void display() {
        System.out.println("Pizza Details:");
        System.out.println("Size: " + size);
        System.out.println("Cheese: " + cheese);
        System.out.println("Pepperoni: " + pepperoni);
        System.out.println("Bacon: " + bacon);
        System.out.println("Mushrooms: " + mushrooms);
    }

    static class Builder {

        private String size;
        private boolean cheese;
        private boolean pepperoni;
        private boolean bacon;
        private boolean mushrooms;

        public Builder(String size) {
            this.size = size;
        }

        public Builder setCheese(boolean cheese) {
            this.cheese = cheese;
            return this;
        }

        public Builder setPepperoni(boolean pepperoni) {
            this.pepperoni = pepperoni;
            return this;
        }

        public Builder setBacon(boolean bacon) {
            this.bacon = bacon;
            return this;
        }

        public Builder setMushrooms(boolean mushrooms) {
            this.mushrooms = mushrooms;
            return this;
        }

        public BuilderWithPatternPizza build() {
            return new BuilderWithPatternPizza(this);
        }
    }

    public static void main(String args[]) {

        BuilderWithPatternPizza pizza =
                new BuilderWithPatternPizza.Builder("Large")
                        .setCheese(true)
                        .setPepperoni(true)
                        .setBacon(false)
                        .setMushrooms(true)
                        .build();

        pizza.display();
    }
}