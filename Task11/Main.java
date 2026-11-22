import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

abstract class Vehicle {
    protected String regNo;

    Vehicle(String regNo) {
        this.regNo = regNo;
    }

    abstract double hourlyRate();
}

class Car extends Vehicle {
    Car(String regNo) { super(regNo); }
    double hourlyRate() { return 20.0; }
}

class Bike extends Vehicle {
    Bike(String regNo) { super(regNo); }
    double hourlyRate() { return 10.0; }
}

class ElectricCar extends Vehicle {
    ElectricCar(String regNo) { super(regNo); }
    double hourlyRate() { return 25.0; }
}

class ParkingTicket {
    String regNo;
    Vehicle vehicle;
    int hours;
    boolean monthlyPass;

    ParkingTicket(Vehicle vehicle, int hours, boolean monthlyPass) {
        this.vehicle = vehicle;
        this.regNo = vehicle.regNo;
        this.hours = hours;
        this.monthlyPass = monthlyPass;
    }

    double fee() {
        if (monthlyPass) return 0.0;
        return vehicle.hourlyRate() * hours;
    }
}

class ParkingSystem {
    private final Map<String, ParkingTicket> active = new HashMap<>();

    boolean park(Vehicle v, int hours, boolean pass) {
        if (active.containsKey(v.regNo)) return false;
        active.put(v.regNo, new ParkingTicket(v, hours, pass));
        return true;
    }

    double exit(String regNo) {
        ParkingTicket ticket = active.remove(regNo);
        if (ticket == null) return -1;
        return ticket.fee();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ParkingSystem system = new ParkingSystem();

        System.out.print("Enter vehicle type (car/bike/ev): ");
        String type = sc.nextLine().trim().toLowerCase();

        System.out.print("Enter registration number: ");
        String regNo = sc.nextLine();

        System.out.print("Enter parking hours: ");
        int hours = sc.nextInt();

        System.out.print("Valid monthly pass? (true/false): ");
        boolean pass = sc.nextBoolean();
        sc.nextLine();

        Vehicle vehicle;
        switch (type) {
            case "car": vehicle = new Car(regNo); break;
            case "bike": vehicle = new Bike(regNo); break;
            case "ev": vehicle = new ElectricCar(regNo); break;
            default:
                System.out.println("Unknown vehicle type");
                sc.close();
                return;
        }

        if (hours < 0) {
            System.out.println("Invalid parking duration");
            sc.close();
            return;
        }

        if (system.park(vehicle, hours, pass)) {
            System.out.println("Vehicle parked successfully");
            double fee = system.exit(regNo);
            System.out.println("Parking fee: Rs." + fee);
            System.out.println("Slot released successfully");
        } else {
            System.out.println("Duplicate registration number");
        }
        sc.close();
    }
}
