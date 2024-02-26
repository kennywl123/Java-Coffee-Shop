public class CoffeeShop {
    private String shopName; //Assign shopName.
    private int listSize = 100; //Set list length to 100
    private DrinkOrder drinkOrderList[] = new DrinkOrder[listSize]; //Create a list of DrinkOrder objects.
    private double markup; //Assign markup.
    private double totalProfit = 0.0; //Assign totalProfit.
    private int index = 0; //Assign index.
    private static int getTotalOrders = 0; //Assign getTotalOrders.
    private static int totalNumberDrinks; //Assign totalNumberDrinks.
    /*
    *
    * [Is the constructor Method and initializes a newly created object of that type]
    * [It takes as parameters a String shopName, double markup]
    * [It returns the CoffeeShop object]
    *
    */
    public CoffeeShop(String shopName, double markup) {
        this.shopName = shopName;
        this.markup = markup;
    }
    /*
    *
    * [Is the toString() Method and helps to make the String]
    * [Returns an String]
    *
    */
    public String toString(){
        return shopName;
    }
    /*
    *
    * [Is the totalNumberDrinks() Method and return the totalNumberDrinks]
    * [Returns an int]
    *
    */
    public static int totalNumberDrinks() {
        return totalNumberDrinks;
    }
    /*
    *
    * [Is the getName() Method and returns the shopName]
    * [Returns a String]
    *
    */
    public String getName() {
        return shopName;
    }
    /*
    *
    * [The newOrder() method creates a new order for each customer]
    * [The inputs are the drink.calculateCost(), the markup factor, the list, the profit. the total orders and the index]
    * [It creates a DrinkOrder coffeeOrder obeject with new values]
    * [It accepts the parameters Customer customer, Drink drink]
    *
    */
    public void newOrder(Customer customer, Drink drink) {
        double amountCharged = drink.calculateCost() * markup; //Multiply the cost of the drink by the markup factor and determine how much to charge the customer.
        totalNumberDrinks++; //Increase totalNumberDrinks.
        DrinkOrder coffeeOrder = new DrinkOrder(customer, drink, amountCharged); //Creates a DrinkOrder for each customer.
        drinkOrderList[index] = coffeeOrder; //Add the DrinkOrder to the list
        totalProfit += drinkOrderList[index].getProfit(); //Sum the profit of each customer.
        index++; //Increase index.
        getTotalOrders++; //Increase getTotalOrders.
        customer.addStore(this); //Return the shop Name.
    }
    /*
    *
    * [Is the orderFilled() method and check if the drink order is filled and replace the null value with a not filled value]
    * [It uses the findOrderIndex() method to find the filled Drink and replace the value for the next drink]
    * [It takes as a parameter Customer customerName]
    * [It returns a modified list]
    *
    */
    public void orderFilled(Customer customerName) {
        int orderIndex = findOrderIndex(customerName); //Find the index of the customer using the method findOrderIndex.
        if (orderIndex > -1) { //If the index is more than 0 if not is because there is no Drink.
            totalNumberDrinks--;//Decrease totalNumberDrinks .
            for (int i = orderIndex; i < index - 1; i++) {
                drinkOrderList[i] = drinkOrderList[i + 1];//Replace the old value with a new one
            }
            drinkOrderList[index - 1] = null;//Remove repeated orders.
            index--;//Decrease index.
        }
    }
    /*
    *
    * [Is the getNumOrdersPending() Method and return the index]
    * [Return a int]
    *
    */
    public int getNumOrdersPending() {
        return index;
    }
    /*
    *
    * [The findOrderIndex() method is a helper to find the index of the drink that belongs to the customer]
    * [It accepts as parameter the Customer customerName]
    * [It returns an int]
    *
    */
    private int findOrderIndex(Customer customerName) {
        for (int i = 0; i < index; i++) {
            if (drinkOrderList[i].belongsTo(customerName)) {//If the drink belongs to the customer return i.
                return i;//Return the index of where is the customer drink.
            }
        }
        return -1;//If the drink is not found return -1.
    }
    /*
    *
    * [The displayOrdersPending() method displays the orders pending at the shopName]
    * [It prints a String]
    *
    */
    public void displayOrdersPending() {
        System.out.println("Orders pending at " + shopName + ":");
        if (index > 0){
            for (int i = 0; i < index; i++) {
            System.out.println((i + 1) + ":  " + drinkOrderList[i].toString());
            }
        }
        else {
            System.out.println("None");//If there is no orders print none
        }
    }
    /*
    *
    * [Is the getProfit() Method and return the totalProfit]
    * [Return a double]
    *
    */
    public double getProfit() {
        return totalProfit;
    }
    /*
    *
    * [Is the getTotalOrders() Method and return the getTotalOrders]
    * [Return an int]
    *
    */
    public static int getTotalOrders() {     
        return getTotalOrders;
    }
}
