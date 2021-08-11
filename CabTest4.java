package CabInvoiceGeneratorTest;

import CabInvoiceGenerator.CabInvoiceGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CabTest4 {

    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare()
    {
        CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
        double distance = 5.0;
        double time = 2;
        double totalfare =  cabInvoiceGenerator.getfare(distance,time,"regular");
        assertEquals(52, totalfare,0.0);
    }

    @Test
    public void givenDistanceAndTime_WhenLessThanMinimumFare_ShouldReturnTotalFare()
    {
        CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
        double distance = 0.1;
        double time = 2;
        double totalfare =  cabInvoiceGenerator.getfare(distance,time,"regular");
        assertEquals(5, totalfare,0.0);
    }

    @Test
    public void givenMultipleRides_ShouldReturnInvoiceSummary()
    {
        CabInvoiceGenerator cabInvoiceGenerator =new CabInvoiceGenerator();
        Ride4[] rides = { new Ride4(5.0,2),new Ride4(0.1,2)};
        InvoiceSummary3 summary =  cabInvoiceGenerator.calculateTotalFare(1,rides,"regular");
        InvoiceSummary3  expectedSummary = new InvoiceSummary3(1,2,57.0);
        assertEquals(expectedSummary,summary);
    }

    @Test
    public void givenUserID_ShouldReturnListOfRides()
    {
        CabInvoiceGenerator cabInvoiceGenerator =new CabInvoiceGenerator();
        Ride4[] rides = { new Ride4(5.0,2),new Ride4(0.1,2)};
        cabInvoiceGenerator.calculateTotalFare(1,rides,"regular");
        Ride4[] expectedRide = cabInvoiceGenerator.rideRepository.get(1);
        assertEquals(expectedRide.toString(),rides.toString());
    }

    @Test
    public void givenDistanceAndTime_WhenPremium_ShouldReturnTotalFare()
    {
        CabInvoiceGenerator5 cabInvoiceGenerator = new CabInvoiceGenerator5();
        double distance = 2;
        double time = 1;
        double totalfare =  cabInvoiceGenerator.getfare(distance,time,"premium");
        assertEquals(32, totalfare,0.0);
    }

    @Test
    public void givenDistanceAndTime_WhenPremiumAndLessThanMinimum_ShouldReturnTotalFare()
    {
        CabInvoiceGenerator5 cabInvoiceGenerator = new CabInvoiceGenerator5();
        double distance = 1;
        double time = 1;
        double totalfare =  cabInvoiceGenerator.getfare(distance,time,"premium");
        assertEquals(20, totalfare,0.0);
    }
}
