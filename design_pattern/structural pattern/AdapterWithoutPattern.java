interface AppleCharger {

    void chargePhone();
}

interface AndroidCharger {

    void chargeAndroidPhone();
}


// Apple Charger

class ChargerXYZ implements AppleCharger {

    @Override
    public void chargePhone() {
        System.out.println("iPhone is charging with Apple Charger");
    }
}


// Android Charger

class DkCharger implements AndroidCharger {

    @Override
    public void chargeAndroidPhone() {
        System.out.println("Android phone is charging with Android Charger");
    }
}


// iPhone

class Iphone13 {

    private AppleCharger appleCharger;

    public Iphone13(AppleCharger appleCharger) {
        this.appleCharger = appleCharger;
    }

    public void chargeIphone() {
        appleCharger.chargePhone();
    }
}


// Android Phone

class Samsung {

    private AndroidCharger androidCharger;

    public Samsung(AndroidCharger androidCharger) {
        this.androidCharger = androidCharger;
    }

    public void chargeSamsung() {
        androidCharger.chargeAndroidPhone();
    }
}


public class AdapterWithoutPattern {

    public static void main(String[] args) {

        System.out.println("Program started");

        // Apple charger -> iPhone
        AppleCharger appleCharger = new ChargerXYZ();

        Iphone13 iphone13 = new Iphone13(appleCharger);

        iphone13.chargeIphone();


        // Android charger -> Samsung
        AndroidCharger androidCharger = new DkCharger();

        Samsung samsung = new Samsung(androidCharger);

        samsung.chargeSamsung();
    }
}