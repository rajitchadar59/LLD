interface Bike {

    void start();
}

class Honda implements Bike {

    public void start() {
        System.out.println("Honda bike started");
    }
}

class Yamaha implements Bike {

    public void start() {
        System.out.println("Yamaha bike started");
    }
}

class RoyalEnfield implements Bike {

    public void start() {
        System.out.println("Royal Enfield bike started");
    }
}

class KTM implements Bike {

    public void start() {
        System.out.println("KTM bike started");
    }
}

public class FactoryWithoutPattern {

    public static void main(String[] args) {

        String type = "yamaha";

        Bike bike;

        if (type.equals("honda")) {

            bike = new Honda();

        } else if (type.equals("yamaha")) {

            bike = new Yamaha();

        } else if (type.equals("royalenfield")) {

            bike = new RoyalEnfield();

        } else if (type.equals("ktm")) {

            bike = new KTM();

        } else {

            bike = null;
        }

        if (bike != null) {
            bike.start();
        }
    }
}