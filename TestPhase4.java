public class TestPhase4 {

  public static void main(String[] args) {

    // set up some customers
    Customer bruno = new Customer("Bruno", "Mars");
    Customer taylor = new Customer("Taylor", "Swift");
    Customer ada = new Customer("Lovelace", "Ada");

    // set up some ingredients
    Ingredient milk = new Ingredient("Milk", 500, 2.55);
    Ingredient espresso = new Ingredient("Espresso", 100, 4.05);
    Ingredient syrup = new Ingredient("Hazelnut Syrup", 30, 13.5);
    Ingredient soyMilk = new Ingredient("Soy Milk", 500, 4.75);

    // set up some drinks
    Drink late = new Drink("Late");
    late.addIngredient(milk);
    late.addIngredient(espresso);

    Drink soyLate = new Drink("Soy Late");
    soyLate.addIngredient(soyMilk);
    soyLate.addIngredient(espresso);

    Drink hazeLate = new Drink("Hazelnut Late");
    hazeLate.addIngredient(milk);
    hazeLate.addIngredient(espresso);
    hazeLate.addIngredient(syrup);

    // Set up some stores
    CoffeeShop starbucks = new CoffeeShop("Starbucks", 3.5);
    CoffeeShop secondCup = new CoffeeShop("Second Cup", 2.1);

    starbucks.newOrder(bruno, late);
    starbucks.displayOrdersPending();
    System.out.println(starbucks.getName() + " profit: " + starbucks.getProfit());
    System.out.println();

    starbucks.newOrder(taylor, soyLate);
    starbucks.displayOrdersPending();
    System.out.println(starbucks.getName() + " profit: " + starbucks.getProfit());
    System.out.println();

    System.out.println("Filled order at Starbucks: " + taylor);
    starbucks.orderFilled(taylor);
    starbucks.displayOrdersPending();

    secondCup.newOrder(ada, late);
    secondCup.newOrder(taylor, soyLate);
    secondCup.displayOrdersPending();
    System.out.println(secondCup.getName() + " profit: " + secondCup.getProfit());
    System.out.println();

    secondCup.newOrder(bruno, hazeLate);
    secondCup.displayOrdersPending();
    System.out.println(secondCup.getName() + " profit: " + secondCup.getProfit());
    System.out.println();

    System.out.println("Trying to fill an order not at Starbucks: " + ada);
    starbucks.orderFilled(ada);
    starbucks.displayOrdersPending();

    System.out.println("Filled order at Starbucks: " + bruno);
    starbucks.orderFilled(bruno);
    starbucks.displayOrdersPending();

    starbucks.newOrder(taylor, hazeLate);
    starbucks.displayOrdersPending();
    System.out.println(starbucks.getName() + " profit: " + starbucks.getProfit());
    System.out.println();

    System.out.println("Total coffee orders: " + CoffeeShop.getTotalOrders());
    System.out.println();

    System.out.println(taylor + " has visited: ");
    taylor.displayStoresVisited();
    System.out.println();

    System.out.println(bruno + " has visited: ");
    bruno.displayStoresVisited();
    System.out.println();

    System.out.println(ada + " has visited: ");
    ada.displayStoresVisited();
    System.out.println();

    System.out.println("shortest wait for: " + taylor + " is: " + taylor.getShortestWait().getName());
    System.out.println("shortest wait for: " + ada + " is: " + ada.getShortestWait().getName());

  }
}