import java.util.Scanner;

class ParkingSlot {
    private int slotNo;
    private boolean occupied;

    ParkingSlot(int slotNo) {
        setSlotNo(slotNo);
        occupied = false;
    }

    public void setSlotNo(int slotNo) {
        if (slotNo <= 0) {
            throw new IllegalArgumentException("Slot number must be positive");
        }
        this.slotNo = slotNo;
    }

    public int getSlotNo() {
        return slotNo;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter slot number: ");
        int number = sc.nextInt();

        try {
            ParkingSlot slot = new ParkingSlot(number);
            slot.setOccupied(true);

            System.out.println("Slot Number: " + slot.getSlotNo());
            System.out.println("Occupied: " + slot.isOccupied());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
        sc.close();
    }
}
