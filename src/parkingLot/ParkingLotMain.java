package parkingLot;

import parkingLot.dao.*;

/**
 * Entities for Parking Lot -
 * 1.) Parking Floor
 * 2.) Parking Spot
 * 3.) Vehicle
 * 4.)
 */

public class ParkingLotMain {

    /*public static void main(String[] args) {
        ParkingFloor f1 = new ParkingFloor("F1");
        f1.addSpot(new BikeSpot("B1"));
        f1.addSpot(new CompactSpot("C1"));
        f1.addSpot(new LargeSpot("L1"));

        ParkingFloor f2 = new ParkingFloor("F2");
        f2.addSpot(new CompactSpot("C2"));
        f2.addSpot(new LargeSpot("L2"));

        ParkingLot lot = new ParkingLot(
                "LOT-1",
                List.of(f1, f2),
                new NearestFirstAllocationStrategy(),
                new HourlyPricingStrategy(10, 30, 60)
        );

        EntryGate entry = new EntryGate("GATE-IN-1", lot);
        ExitGate exit = new ExitGate("GATE-OUT-1", lot);

        Vehicle car = new Vehicle("KA-01-1234", VehicleType.CAR);

        Ticket ticket = entry.enter(car).orElseThrow(() -> new RuntimeException("No spot available"));
        System.out.println("Ticket issued: " + ticket.getTicketId() + " spot=" + ticket.getSpotId());

        PaymentReceipt receipt = exit.exit(ticket.getTicketId()).orElseThrow();
        System.out.println("Paid: " + receipt.getAmountPaid() + " at " + receipt.getPaidAt());
    }*/
}
