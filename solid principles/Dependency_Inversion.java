// WITH PRINCIPLE

interface InputDevice {
    void input();
}

interface DisplayDevice {
    void display();
}

class Keyboard implements InputDevice {

    public void input() {
        System.out.println("Keyboard typing...");
    }
}

class Monitor implements DisplayDevice {

    public void display() {
        System.out.println("Monitor displaying...");
    }
}

class Computer {

    private InputDevice inputDevice;
    private DisplayDevice displayDevice;

    Computer(InputDevice inputDevice, DisplayDevice displayDevice) {
        this.inputDevice = inputDevice;
        this.displayDevice = displayDevice;
    }

    void start() {
        inputDevice.input();
        displayDevice.display();
        System.out.println("Computer started");
    }
}

public class Dependency_Inversion {

    public static void main(String[] args) {

        InputDevice keyboard = new Keyboard();
        DisplayDevice monitor = new Monitor();

        Computer computer = new Computer(keyboard, monitor);

        computer.start();
    }
}

// WITHOUT PRINCIPLE

/*
class Keyboard {

    void type() {
        System.out.println("Keyboard typing...");
    }
}

class Monitor {

    void display() {
        System.out.println("Monitor displaying...");
    }
}

class Computer {

    Keyboard keyboard = new Keyboard();
    Monitor monitor = new Monitor();

    void start() {
        keyboard.type();
        monitor.display();
        System.out.println("Computer started");
    }
}

public class Main {

    public static void main(String[] args) {

        Computer computer = new Computer();

        computer.start();
    }
}


*/