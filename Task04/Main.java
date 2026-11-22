import java.util.Scanner;

class ParkingTicket {
    private int ticketNo;
    private String vehicleNo;

    ParkingTicket() {
        this(0, "Not assigned");
    }

    ParkingTicket(int ticketNo, String vehicleNo) {
        this.ticketNo = ticketNo;
        this.vehicleNo = vehicleNo;
    }

    ParkingTicket(ParkingTicket other) {
        this(other.ticketNo, other.vehicleNo);
    }

    void display() {
        System.out.println("Ticket Number: " + ticketNo);
        System.out.println("Vehicle Number: " + vehicleNo);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter ticket number: ");
        int number = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter vehicle number: ");
        String vehicle = sc.nextLine();

        ParkingTicket ticket1 = new ParkingTicket(number, vehicle);
        ParkingTicket ticket2 = new ParkingTicket(ticket1);

        System.out.println("\nOriginal ticket:");
        ticket1.display();

        System.out.println("\nCopied ticket:");
        ticket2.display();
        sc.close();
    }
}
