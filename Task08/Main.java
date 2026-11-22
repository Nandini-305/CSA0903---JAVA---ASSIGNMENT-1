import java.util.Scanner;

class Vehicle {
    double calculateFee() {
        return 0.0;
    }

    double calculateFee(int hours) {
        return hours * 20.0;
    }
}

class Car extends Vehicle {
    @Override
    double calculateFee() {
        return 50.0;
    }
}

class Bike extends Vehicle {
    @Override
    double calculateFee() {
        return 20.0;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Vehicle[] vehicles = {new Car(), new Bike()};

        System.out.println("Runtime polymorphism:");
        for (Vehicle v : vehicles) {
            System.out.println(v.getClass().getSimpleName() +
                               " fee: " + v.calculateFee());
        }

        System.out.print("Enter parking hours for overloaded method: ");
        int hours = sc.nextInt();
        System.out.println("Fee for " + hours + " hours: " +
                           vehicles[0].calculateFee(hours));
        sc.close();
    }
}
