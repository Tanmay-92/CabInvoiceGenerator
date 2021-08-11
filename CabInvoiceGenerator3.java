package CabInvoiceGenerator;

public class CabInvoiceGenerator3 {

    private static final double FARE_PER_KM = 10;
    private static final double FARE_PER_MINUTE = 1;
    private static final double MINIMUM_FARE = 5;

    public double getfare(double distance, double time)
    {
        double fare = distance*FARE_PER_KM + time*FARE_PER_MINUTE;
        return Math.max(MINIMUM_FARE, fare);
    }

    public InvoiceSummary calculateTotalFare(Ride2[] rides)
    {
        double totalFare = 0;
        for (Ride2 ride : rides)
        {
            totalFare+=getfare(ride.distance, ride.time);
        }
        return new InvoiceSummary(rides.length, totalFare);
    }
}
