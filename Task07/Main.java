import java.util.Scanner;
import java.util.Objects;

class Vehicle {
    private String registrationNo;

    Vehicle(String registrationNo) {
        this.registrationNo = registrationNo;
    }

    double calculateFee() {
        return 0.0;
    }

    @Override
    public String toString() {
        return "Vehicle: " + registrationNo;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Vehicle)) return false;
        Vehicle other = (Vehicle) obj;
        return registrationNo.equals(other.registrationNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(registrationNo);
    }
}

class Car extends Vehicle {
    Car(String registrationNo) {
        super(registrationNo);
    }

    @Override
    double calculateFee() {
        return 50.0;
    }

    @Override
    public String toString() {
        return "Car parking fee: " + calculateFee();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first registration number: ");
        Vehicle v1 = new Car(sc.nextLine());

        System.out.print("Enter second registration number: ");
        Vehicle v2 = new Car(sc.nextLine());

        System.out.println(v1);
        System.out.println("Fee: " + v1.calculateFee());
        System.out.println("Same registration? " + v1.equals(v2));
        sc.close();
    }
}
