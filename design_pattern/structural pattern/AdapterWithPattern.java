interface AppleCharger {

    void chargePhone();
}

interface AndroidCharger {

    void chargeAndroidPhone();
}


// Existing Android Charger

class DkCharger implements AndroidCharger {

    @Override
    public void chargeAndroidPhone() {
        System.out.println("Android charger is supplying power");
    }
}


// Normal Apple Charger

class ChargerXYZ implements AppleCharger {

    @Override
    public void chargePhone() {
        System.out.println("iPhone is charging with Apple Charger");
    }
}


// iPhone expects AppleCharger

class Iphone13 {

    private AppleCharger appleCharger;

    public Iphone13(AppleCharger appleCharger) {
        this.appleCharger = appleCharger;
    }

    public void chargeIphone() {
        appleCharger.chargePhone();
    }
}


// Adapter

class AdapterCharger implements AppleCharger {

    private AndroidCharger androidCharger;

    public AdapterCharger(AndroidCharger androidCharger) {
        this.androidCharger = androidCharger;
    }

    @Override
    public void chargePhone() {

        androidCharger.chargeAndroidPhone();

        System.out.println("iPhone is charging using Android Charger through Adapter");
    }
}


public class AdapterWithPattern {

    public static void main(String[] args) {

        System.out.println("Program started");

        // Existing Android Charger
        AndroidCharger androidCharger = new DkCharger();

        // AndroidCharger -> Adapter -> AppleCharger
        AppleCharger adapter = new AdapterCharger(androidCharger);

        // iPhone accepts AppleCharger
        Iphone13 iphone13 = new Iphone13(adapter);

        iphone13.chargeIphone();
    }
}