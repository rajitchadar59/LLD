// WITH PRINCIPLE

class User {

    void showUser() {
        System.out.println("User information");
    }
}

class UserRepository {

    void saveUser() {
        System.out.println("Saving user to database...");
    }
}

class EmailService {

    void sendEmail() {
        System.out.println("Sending email...");
    }
}

class ReportService {

    void generateReport() {
        System.out.println("Generating report...");
    }
}

public class SingleResponsibility {
    public static void main(String[] args) {

        User user = new User();
        UserRepository repository = new UserRepository();
        EmailService email = new EmailService();
        ReportService report = new ReportService();

        user.showUser();
        repository.saveUser();
        email.sendEmail();
        report.generateReport();
    }
}




// WITHOUT PRINCIPLE
/*

class User {

    void saveUser() {
        System.out.println("Saving user to database...");
    }

    void sendEmail() {
        System.out.println("Sending email...");
    }

    void generateReport() {
        System.out.println("Generating report...");
    }
}

public class SingleResponsibility {
    public static void main(String[] args) {

        User user = new User();

        user.saveUser();
        user.sendEmail();
        user.generateReport();
    }
}



*/