import java.util.Scanner;

class ParkingTicket {
    private static int counter = 100;
    private int ticketNo;
    private String vehicleNo;

    ParkingTicket(String vehicleNo) {
        this.vehicleNo = vehicleNo;
        ticketNo = ++counter;
    }

    void display() {
        System.out.println("Ticket: " + ticketNo + ", Vehicle: " + vehicleNo);
    }

    static void displayTotalTickets() {
        System.out.println("Total tickets created: " + (counter - 100));
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first vehicle number: ");
        ParkingTicket t1 = new ParkingTicket(sc.nextLine());

        System.out.print("Enter second vehicle number: ");
        ParkingTicket t2 = new ParkingTicket(sc.nextLine());

        t1.display();
        t2.display();
        ParkingTicket.displayTotalTickets();
        sc.close();
    }
}
