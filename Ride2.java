package CabInvoiceGenerator;

public class Ride2 {
    public double distance;
    public double time;
    public Ride2(double distance, double time)
    {
        super();
        this.distance = distance;
        this.time = time;
    }
    @Override
    public String toString()
    {
        return "Ride [distance=" + distance + ", time=" + time + "]";
    }
}
