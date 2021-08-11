package CabInvoiceGeneratorTest;


import CabInvoiceGenerator.CabInGenerator;
import CabInvoiceGenerator.Ride;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CabTest {
    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare()
    {
        CabInGenerator cabInGenerator = new CabInGenerator();
        double distance = 5.0;
        double time = 2;
        double totalfare =  cabInGenerator.getfare(distance,time);
        assertEquals(52, totalfare,0.0);
    }

    @Test
    public void givenDistanceAndTime_WhenLessThanMinimumFare_ShouldReturnTotalFare()
    {
        CabInGenerator cabInGenerator = new CabInGenerator();
        double distance = 0.1;
        double time = 2;
        double totalfare =  cabInGenerator.getfare(distance,time);
        assertEquals(5, totalfare,0.0);
    }

    @Test
    public void givenMultipleRides_ShouldReturnTotalFare()
    {
        CabInGenerator cabInGenerator =new CabInGenerator();
        Ride[] rides = { new Ride(5.0,2),new Ride(0.1,2)};
        double totalfare =  cabInGenerator.calculateTotalFare(rides);
        assertEquals(57, totalfare,0.0);
    }

}
