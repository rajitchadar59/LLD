class DatabaseService {

    DatabaseService() {
        System.out.println("Database Service Created");
    }

    void connect() {
        System.out.println("Connected to Database");
    }
}

public class SingletonWithoutPattern {

    public static void main(String[] args) {

        DatabaseService service1 = new DatabaseService();
        DatabaseService service2 = new DatabaseService();
        DatabaseService service3 = new DatabaseService();

        service1.connect();
        service2.connect();
        service3.connect();

        System.out.println(service1 == service2); // false
        System.out.println(service2 == service3); // false
    }
}
