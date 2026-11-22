import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of floors: ");
        int floors = sc.nextInt();

        int[] slotsPerFloor = new int[floors];
        String[][] slots = new String[floors][];

        for (int i = 0; i < floors; i++) {
            System.out.print("Enter slots on floor " + i + ": ");
            slotsPerFloor[i] = sc.nextInt();
            slots[i] = new String[slotsPerFloor[i]];
        }

        System.out.println("\nParking slot representation:");
        for (int i = 0; i < floors; i++) {
            System.out.println("Floor " + i + ": " + slots[i].length + " slots");
        }

        int minutes = 90;
        double hours = minutes / 60.0;
        System.out.println("\nParking minutes: " + minutes);
        System.out.println("Hours (decimal): " + hours);

        sc.close();
    }
}
