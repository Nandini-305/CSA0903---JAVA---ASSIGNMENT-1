import java.util.Scanner;

abstract class Vehicle {
    protected String registrationNo;

    Vehicle(String registrationNo) {
        this.registrationNo = registrationNo;
    }

    abstract double calculateFee();
}

interface Chargeable {
    void charge();

    default void chargingInfo() {
        System.out.println("Vehicle supports charging");
    }
}

class ElectricCar extends Vehicle implements Chargeable {
    ElectricCar(String registrationNo) {
        super(registrationNo);
    }

    @Override
    double calculateFee() {
        return 40.0;
    }

    @Override
    public void charge() {
        System.out.println("Electric car is charging");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter electric vehicle number: ");
        ElectricCar car = new ElectricCar(sc.nextLine());

        System.out.println("Registration Number: " + car.registrationNo);
        System.out.println("Parking Fee: " + car.calculateFee());
        car.charge();
        car.chargingInfo();
        sc.close();
    }
}
