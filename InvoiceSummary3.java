package CabInvoiceGenerator;

public class InvoiceSummary3 {

    public int userID;
    public int numberOfRides;
    public double totalFare;
    public double avarage;
    public InvoiceSummary3(int userid ,int numberOfRides, double totalFare)
    {
        super();
        this.numberOfRides = numberOfRides;
        this.totalFare = totalFare;
        this.avarage = this.totalFare/this.totalFare;
    }

    @Override
    public String toString()
    {
        return "InvoiceSummary [numberOfRides=" + numberOfRides + ", totalFare=" + totalFare + ", avarage=" + avarage
                + "]";
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        InvoiceSummary3 other = (InvoiceSummary3) obj;
        return Double.doubleToLongBits(avarage) == Double.doubleToLongBits(other.avarage)
                && numberOfRides == other.numberOfRides
                && Double.doubleToLongBits(totalFare) == Double.doubleToLongBits(other.totalFare);
    }


}
