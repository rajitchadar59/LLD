class IDCard {

    String college;
    String branch;
    String year;
    String name;

    IDCard(String college, String branch, String year, String name) {

        this.college = college;
        this.branch = branch;
        this.year = year;
        this.name = name;
    }

    void display() {

        System.out.println("College : " + college);
        System.out.println("Name    : " + name);
        System.out.println("Branch  : " + branch);
        System.out.println("Year    : " + year);
        System.out.println();
    }
}

public class PrototypeWithoutPattern {

    public static void main(String[] args) {

        IDCard rajit = new IDCard(
                "Jabalpur Engineering College",
                "CSE",
                "4th Year",
                "Rajit"
        );

        IDCard aman = new IDCard(
                "Jabalpur Engineering College",
                "CSE",
                "3rd Year",
                "Aman"
        );

        IDCard rohit = new IDCard(
                "Jabalpur Engineering College",
                "CSE",
                "3rd Year",
                "Rohit"
        );

        rajit.display();
        aman.display();
        rohit.display();
    }
}