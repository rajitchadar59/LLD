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

class BikeFactory {

    public   Bike createBike(String type) {

        if (type.equals("honda")) {

            return new Honda();

        } else if (type.equals("yamaha")) {

            return new Yamaha();

        } else if (type.equals("royalenfield")) {

            return new RoyalEnfield();

        } else if (type.equals("ktm")) {

            return new KTM();

        }

        return null;
    }
}

public class FactoryWithPattern {

    public static void main(String[] args) {
        BikeFactory bf = new BikeFactory();
        Bike bike = bf.createBike("yamaha");

        if (bike != null) {
            bike.start();
        }
    }
}