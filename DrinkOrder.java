public class DrinkOrder {
    private Customer customer; //Assign customer.
    private Drink drink; //Assign drink.
    private double amountCharged; //Assign amountCharged.
    /*
    *
    * [Is the constructor Method and initializes a newly created object of that type]
    * [It takes as parameters a Customer customer, Drink drink, double amountCharged]
    * [It returns the DrinkOrder object]
    *
    */
    public DrinkOrder (Customer customer, Drink drink, double amountCharged) {
        this.customer = customer;
        this.drink = drink;
        this.amountCharged = amountCharged;
    }
    /*
    *
    * [Is the belongsTo() method that return a boolean if the customer match with the Customer customerName]
    * [It accepts the parameter Customer customerName]
    * [Returns a boolean]
    *
    */
    public boolean belongsTo(Customer customerName) {
        if (customerName.equals(customer)){
            return true;
        }
        return false;
    }
    /*
    *
    * [Is the getProfit() method that returns the profit of each drink]
    * [Takes as input the amountCharged and the cost of the drink]
    * [It returns a double]
    *
    */
    public double getProfit() {
        return amountCharged - drink.calculateCost();//Amount charge -  the cost of the sum of every ingredients
    }
    /*
    *
    * [Is the toString() Method and helps to make the String]
    * [It returns a String]
    *
    */
    public String toString() {
        StringBuilder drinkOrderString = new StringBuilder();  //StringBuilder containing the customer, amount charged, and drink information.
        drinkOrderString.append(customer).append(", $").append(amountCharged).append(": ").append(drink.toString());
        return drinkOrderString.toString(); //Return the final String
    }
}
