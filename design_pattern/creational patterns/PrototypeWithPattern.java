class IDCard implements Cloneable {

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

    public IDCard clone() {

        try {

            return (IDCard) super.clone();

        } catch (CloneNotSupportedException e) {

            throw new RuntimeException(e);
        }
    }

    void display() {

        System.out.println("College : " + college);
        System.out.println("Name    : " + name);
        System.out.println("Branch  : " + branch);
        System.out.println("Year    : " + year);
        System.out.println();
    }
}

public class PrototypeWithPattern {

    public static void main(String[] args) {

        // Original / Prototype
        IDCard prototype = new IDCard(
                "Jabalpur Engineering College",
                "CSE",
                "3rd Year",
                ""
        );

        // Clone
        IDCard rajit = prototype.clone();
        rajit.name = "Rajit";

        IDCard aman = prototype.clone();
        aman.name = "Aman";

        IDCard rohit = prototype.clone();
        rohit.name = "Rohit";

        rajit.display();
        aman.display();
        rohit.display();
    }
}