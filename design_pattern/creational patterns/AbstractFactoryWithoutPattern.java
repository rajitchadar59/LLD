interface Bike {

    void start();
}

interface BikeEngine {

    void engineStart();
}


// Honda Family

class Honda implements Bike {

    public void start() {
        System.out.println("Honda bike started");
    }
}

class HondaEngine implements BikeEngine {

    public void engineStart() {
        System.out.println("Honda engine started");
    }
}


// Yamaha Family

class Yamaha implements Bike {

    public void start() {
        System.out.println("Yamaha bike started");
    }
}

class YamahaEngine implements BikeEngine {

    public void engineStart() {
        System.out.println("Yamaha engine started");
    }
}


// Royal Enfield Family

class RoyalEnfield implements Bike {

    public void start() {
        System.out.println("Royal Enfield bike started");
    }
}

class RoyalEnfieldEngine implements BikeEngine {

    public void engineStart() {
        System.out.println("Royal Enfield engine started");
    }
}


// KTM Family

class KTM implements Bike {

    public void start() {
        System.out.println("KTM bike started");
    }
}

class KTMEngine implements BikeEngine {

    public void engineStart() {
        System.out.println("KTM engine started");
    }
}


public class AbstractFactoryWithoutPattern {

    public static void main(String[] args) {

        String type = "honda";

        Bike bike;
        BikeEngine engine;

        if (type.equals("honda")) {

            bike = new Honda();
            engine = new HondaEngine();

        } else if (type.equals("yamaha")) {

            bike = new Yamaha();
            engine = new YamahaEngine();

        } else if (type.equals("royalenfield")) {

            bike = new RoyalEnfield();
            engine = new RoyalEnfieldEngine();

        } else if (type.equals("ktm")) {

            bike = new KTM();
            engine = new KTMEngine();

        } else {

            bike = null;
            engine = null;
        }

        if (bike != null && engine != null) {

            bike.start();
            engine.engineStart();
        }
    }
}