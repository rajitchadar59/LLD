// WITH PRINCIPLE

class Bird {

    void eat() {
        System.out.println("Bird is eating");
    }
}

class FlyingBird extends Bird {

    void fly() {
        System.out.println("Bird is flying");
    }
}

class Sparrow extends FlyingBird {
}

class Penguin extends Bird {

    void swim() {
        System.out.println("Penguin is swimming");
    }
}

public class Liskov_Substitution {

    public static void main(String[] args) {

        Sparrow bird1 = new Sparrow();
        bird1.eat();
        bird1.fly();


     /*   Parent reference can point to a child object, but it can access only the methods 
     available in the parent reference type.The child-specific methods cannot be accessed 
     directly through the parent reference */
        

        FlyingBird bird2 = new Sparrow();
        bird2.fly();

        Bird bird3 = new Penguin();
        bird3.eat();

        Penguin penguin = new Penguin();
        penguin.swim();
    }
}





// WITHOUT PRINCIPLE 

/*

class Bird {

    void fly() {
        System.out.println("Bird is flying");
    }
}

class Sparrow extends Bird {

    @Override
    void fly() {
        System.out.println("Sparrow is flying");
    }
}

class Penguin extends Bird {

    @Override
    void fly() {
        System.out.println("Penguin cannot fly");
    }
}

public class Liskov_Substitution {

    public static void main(String[] args) {

        Bird bird1 = new Sparrow();
        bird1.fly();

        Bird bird2 = new Penguin();
        bird2.fly();
    }
}



*/