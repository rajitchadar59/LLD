// WITH PRINCIPLE

interface Payment {

    void pay();
}

class UpiPayment implements Payment {
    @Override
    public void pay() {
        System.out.println("Payment using UPI");
    }
}

class CardPayment implements Payment {
     @Override
    public void pay() {
        System.out.println("Payment using Card");
    }
}

class CashPayment implements Payment {
    @Override
    public void pay() {
        System.out.println("Payment using Cash");
    }
}

class PaymentService {
    
    void processPayment(Payment payment) {
        payment.pay();
    }
}

public class OpenClosedPrinciple {

    public static void main(String[] args) {

        PaymentService service = new PaymentService();

        service.processPayment(new UpiPayment());
        service.processPayment(new CardPayment());
        service.processPayment(new CashPayment());
    }
}


// WITHOUT PRINCIPLE

/*  



class PaymentService {

    void pay(String type) {

        if (type.equals("UPI")) {
            System.out.println("Payment using UPI");
        }
        else if (type.equals("CARD")) {
            System.out.println("Payment using Card");
        }
    }
}

public class OpenClosedPrinciple {
    public static void main(String[] args) {

        PaymentService payment = new PaymentService();

        payment.pay("UPI");
        payment.pay("CARD");
    }
}


*/