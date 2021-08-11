package CabInvoiceGeneratorTest;

import CabInvoiceGenerator.CabInvoiceGenerator3;
import CabInvoiceGenerator.InvoiceSummary;
import CabInvoiceGenerator.Ride2;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CabTest2 {

    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare()
    {
        CabInvoiceGenerator3 cabInvoiceGenerator = new CabInvoiceGenerator3();
        double distance = 5.0;
        double time = 2;
        double totalfare =  cabInvoiceGenerator.getfare(distance,time);
        assertEquals(52, totalfare,0.0);
    }

    @Test
    public void givenDistanceAndTime_WhenLessThanMinimumFare_ShouldReturnTotalFare()
    {
        CabInvoiceGenerator3 cabInvoiceGenerator = new CabInvoiceGenerator3();
        double distance = 0.1;
        double time = 2;
        double totalfare =  cabInvoiceGenerator.getfare(distance,time);
        assertEquals(5, totalfare,0.0);
    }

    @Test
    public void givenMultipleRides_ShouldReturnInvoiceSummary()
    {
        CabInvoiceGenerator3 cabInvoiceGenerator =new CabInvoiceGenerator3();
        Ride2[] rides = { new Ride2(5.0,2),new Ride2(0.1,2)};
        InvoiceSummary summary =  cabInvoiceGenerator.calculateTotalFare(rides);
        InvoiceSummary  expectedSummary = new InvoiceSummary(2,57.0);
        assertEquals(expectedSummary,summary);
    }
}
