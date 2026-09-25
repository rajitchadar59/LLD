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


// Abstract Factory

interface BikeFactory {

    Bike createBike();

    BikeEngine createEngine();
}


// Honda Factory

class HondaFactory implements BikeFactory {

    public Bike createBike() {

        return new Honda();
    }

    public BikeEngine createEngine() {

        return new HondaEngine();
    }
}


// Yamaha Factory

class YamahaFactory implements BikeFactory {

    public Bike createBike() {

        return new Yamaha();
    }

    public BikeEngine createEngine() {

        return new YamahaEngine();
    }
}


// Royal Enfield Factory

class RoyalEnfieldFactory implements BikeFactory {

    public Bike createBike() {

        return new RoyalEnfield();
    }

    public BikeEngine createEngine() {

        return new RoyalEnfieldEngine();
    }
}


// KTM Factory

class KTMFactory implements BikeFactory {

    public Bike createBike() {

        return new KTM();
    }

    public BikeEngine createEngine() {

        return new KTMEngine();
    }
}


// Client

public class AbstractFactoryWithPattern {

    public static void main(String[] args) {

        BikeFactory factory = new HondaFactory();

        Bike bike = factory.createBike();

        BikeEngine engine = factory.createEngine();

        bike.start();

        engine.engineStart();
    }
}