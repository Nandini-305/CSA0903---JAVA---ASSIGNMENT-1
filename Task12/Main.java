import java.time.LocalTime;
import java.util.Scanner;

abstract class Vehicle {
    protected String regNo;

    Vehicle(String regNo) {
        this.regNo = regNo;
    }

    abstract double calculateFee(LocalTime entryTime, int hours);
}

class Car extends Vehicle {
    Car(String regNo) { super(regNo); }

    @Override
    double calculateFee(LocalTime entryTime, int hours) {
        return 20.0 * hours;
    }
}

class EBike extends Vehicle {
    EBike(String regNo) { super(regNo); }

    @Override
    double calculateFee(LocalTime entryTime, int hours) {
        return 30.0;
    }
}

class DeliveryVan extends Vehicle {
    DeliveryVan(String regNo) { super(regNo); }

    @Override
    double calculateFee(LocalTime entryTime, int hours) {
        double carRate = 20.0;
        boolean daytime = !entryTime.isBefore(LocalTime.of(9, 0))
                          && entryTime.isBefore(LocalTime.of(17, 0));
        return (daytime ? 2 * carRate : carRate) * hours;
    }
}

interface ParkingPass {
    boolean isValid();
}

class OneDayPass implements ParkingPass {
    public boolean isValid() {
        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] slotsPerFloor = {2, 3, 2, 4, 3};
        String[][] slots = new String[5][];

        for (int i = 0; i < 5; i++) {
            slots[i] = new String[slotsPerFloor[i]];
        }

        System.out.print("Enter vehicle type (car/ebike/van): ");
        String type = sc.nextLine().trim().toLowerCase();

        System.out.print("Enter registration number: ");
        String regNo = sc.nextLine();

        System.out.print("Enter entry time (HH:MM): ");
        LocalTime entry = LocalTime.parse(sc.nextLine());

        System.out.print("Enter parking hours: ");
        int hours = sc.nextInt();
        sc.nextLine();

        System.out.print("One-day pass? (yes/no): ");
        String passAnswer = sc.nextLine().trim().toLowerCase();

        Vehicle vehicle;
        switch (type) {
            case "car": vehicle = new Car(regNo); break;
            case "ebike": vehicle = new EBike(regNo); break;
            case "van": vehicle = new DeliveryVan(regNo); break;
            default:
                System.out.println("Unknown vehicle type");
                sc.close();
                return;
        }

        int[] position = null;
        for (int f = 0; f < slots.length && position == null; f++) {
            for (int s = 0; s < slots[f].length; s++) {
                if (slots[f][s] == null) {
                    slots[f][s] = regNo;
                    position = new int[]{f, s};
                    break;
                }
            }
        }

        if (position == null) {
            System.out.println("Parking full");
        } else {
            double fee = vehicle.calculateFee(entry, hours);
            if (passAnswer.equals("yes")) {
                ParkingPass pass = new OneDayPass();
                if (pass.isValid()) fee = 0.0;
            }

            System.out.println("Vehicle parked successfully");
            System.out.println("Allocated floor: " + position[0]);
            System.out.println("Allocated slot: " + position[1]);
            System.out.println("Parking fee: Rs." + fee);
            slots[position[0]][position[1]] = null;
            System.out.println("Slot released successfully");
        }
        sc.close();
    }
}
