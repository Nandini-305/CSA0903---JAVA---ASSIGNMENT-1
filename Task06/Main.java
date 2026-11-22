import java.util.Scanner;

class Vehicle {
    protected String registrationNo;

    Vehicle(String registrationNo) {
        this.registrationNo = registrationNo;
        System.out.println("Vehicle constructor");
    }
}

class Car extends Vehicle {
    Car(String registrationNo) {
        super(registrationNo);
        System.out.println("Car constructor");
    }
}

class ElectricCar extends Car {
    ElectricCar(String registrationNo) {
        super(registrationNo);
        System.out.println("ElectricCar constructor");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter electric car registration number: ");
        String regNo = sc.nextLine();

        ElectricCar car = new ElectricCar(regNo);
        System.out.println("Registration Number: " + car.registrationNo);
        sc.close();
    }
}
