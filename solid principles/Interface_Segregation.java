// WITH PRINCIPLE

interface Workable {

    void work();
}

interface Eatable {

    void eat();
}

interface Sleepable {

    void sleep();
}

class Human implements Workable, Eatable, Sleepable {

    public void work() {
        System.out.println("Human working");
    }

    public void eat() {
        System.out.println("Human eating");
    }

    public void sleep() {
        System.out.println("Human sleeping");
    }
}

class Robot implements Workable {

    public void work() {
        System.out.println("Robot working");
    }
}

public class Interface_Segregation {

    public static void main(String[] args) {

        Human human = new Human();

        human.work();
        human.eat();
        human.sleep();

        Robot robot = new Robot();

        robot.work();
    }
}




// WITHOUT PRINCIPLE

/*
interface Worker {

    void work();

    void eat();

    void sleep();
}

class Human implements Worker {

    public void work() {
        System.out.println("Human working");
    }

    public void eat() {
        System.out.println("Human eating");
    }

    public void sleep() {
        System.out.println("Human sleeping");
    }
}

class Robot implements Worker {

    public void work() {
        System.out.println("Robot working");
    }

    public void eat() {
        // Robot doesn't eat
    }

    public void sleep() {
        // Robot doesn't sleep
    }
}

public class Interface_Segregation {

    public static void main(String[] args) {

        Robot robot = new Robot();

        robot.work();
    }
}

*/