package CabInvoiceGeneratorTest;

import CabInvoiceGenerator.CabInvoiceGenerator4;
import CabInvoiceGenerator.InvoiceSummary2;
import CabInvoiceGenerator.Ride3;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CabTest3 {


    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare() {
        CabInvoiceGenerator4 cabInvoiceGenerator = new CabInvoiceGenerator4();
        double distance = 5.0;
        double time = 2;
        double totalfare = cabInvoiceGenerator.getfare(distance, time);
        assertEquals(52, totalfare, 0.0);
    }

    @Test
    public void givenDistanceAndTime_WhenLessThanMinimumFare_ShouldReturnTotalFare() {
        CabInvoiceGenerator4 cabInvoiceGenerator = new CabInvoiceGenerator4();
        double distance = 0.1;
        double time = 2;
        double totalfare = cabInvoiceGenerator.getfare(distance, time);
        assertEquals(5, totalfare, 0.0);
    }

    @Test
    public void givenMultipleRides_ShouldReturnInvoiceSummary() {
        CabInvoiceGenerator4 cabInvoiceGenerator = new CabInvoiceGenerator4();
        Ride3[] rides = {new Ride3(5.0, 2), new Ride3(0.1, 2)};
        InvoiceSummary2 summary = cabInvoiceGenerator.calculateTotalFare(1, rides);
        InvoiceSummary2 expectedSummary = new InvoiceSummary2(1, 2, 57.0);
        assertEquals(expectedSummary, summary);
    }

    @Test
    public void givenUserID_ShouldReturnListOfRides() {
        CabInvoiceGenerator4 cabInvoiceGenerator = new CabInvoiceGenerator4();
        Ride3[] rides = {new Ride3(5.0, 2), new Ride3(0.1, 2)};
        cabInvoiceGenerator.calculateTotalFare(1, rides);
        Ride3[] expectedRide = cabInvoiceGenerator.rideRepository.get(1);
        assertEquals(expectedRide.toString(), rides.toString());
    }

}
