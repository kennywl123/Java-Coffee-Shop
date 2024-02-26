public class TransitCalculator {
    int numRides, numDays;
    double[] pricePerRide = { 2.75, 33.00, 127.00 };
    String[] regularFareOptions = { "Pay-per-ride", "7-day Unlimited Rides", "30-days Unlimited Rides" };

    public TransitCalculator(int rides, int days) {
        this.numRides = rides;
        this.numDays = days;
    }

    public double unlimited7Price() {
        int numOfFares = (numDays / 7) + 1; // Num of Fares used in the # of days.
        double price = pricePerRide[1]; // Price of the ticket option "7-day Unlimited Rides".
        double costPerRide = numOfFares * price / numRides; // Cost per ride for 7-day Unlimited Rides option.
        return costPerRide;
    }

    public double[] getRidePrices() {
        double[] pricePerFare = { numRides * pricePerRide[0] / numDays, unlimited7Price(), pricePerRide[2] / numRides };
        return pricePerFare;
    }

    public String getBestFare() {
        String message = "";
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (getRidePrices()[i] < getRidePrices()[j]) {
                    message = "You should get the " + regularFareOptions[i] + " at " + getRidePrices()[i]
                            + " per ride.";
                }
            }
        }
        return message;
    }

    public static void main(String[] args) {
        TransitCalculator firstExample = new TransitCalculator(54, 36);
        TransitCalculator secondExample = new TransitCalculator(12, 5);
        TransitCalculator thirdExample = new TransitCalculator(14, 6);
        System.out.println(firstExample.getBestFare());
        System.out.println(secondExample.getBestFare());
        System.out.println(thirdExample.getBestFare());
    }
}
