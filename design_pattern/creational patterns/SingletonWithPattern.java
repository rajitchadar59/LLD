class DatabaseService {

    private static DatabaseService instance;

    private DatabaseService() {
        System.out.println("Database Service Created");
    }

    public static DatabaseService getInstance() {

        if (instance == null) {
            instance = new DatabaseService();
        }

        return instance;
    }

    void connect() {
        System.out.println("Connected to Database");
    }
}

public class SingletonWithPattern {

    public static void main(String[] args) {

        DatabaseService service1 = DatabaseService.getInstance();
        DatabaseService service2 = DatabaseService.getInstance();
        DatabaseService service3 = DatabaseService.getInstance();

        service1.connect();
        service2.connect();
        service3.connect();

        System.out.println(service1 == service2); // true
        System.out.println(service2 == service3); // true
        System.out.println(service1 == service3); // true
    }
}
