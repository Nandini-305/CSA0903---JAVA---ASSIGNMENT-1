import java.util.Scanner;

class Vehicle {
    private String registrationNo;
    private String type;

    Vehicle(String registrationNo, String type) {
        this.registrationNo = registrationNo;
        this.type = type;
    }

    void display() {
        System.out.println("Registration Number: " + registrationNo);
        System.out.println("Vehicle Type: " + type);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter registration number: ");
        String regNo = sc.nextLine();

        System.out.print("Enter vehicle type: ");
        String type = sc.nextLine();

        Vehicle v = new Vehicle(regNo, type);
        System.out.println("\n--- Vehicle Details ---");
        v.display();
        sc.close();
    }
}
