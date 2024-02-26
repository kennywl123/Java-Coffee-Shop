public class Customer {
    private String firstName; //Assign firstName.
    private String lastName; //Assign lastName. 
    private int listSize = 100; //Set list length to 100. 
    private CoffeeShop shopVisited[] = new CoffeeShop[listSize]; //Create a list of CoffeeShop objects.
    private int numShopVisited; //Num of times that the Shop is visited.
    /*
    *
    * [Is the constructor Method and initializes a newly created object of that type]
    * [It takes as parameters a String firstName, String lastName]
    * [It returns the Customer object]
    *
    */
    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        numShopVisited=0;
    }
    /*
    *
    * [Is the toString() Method and helps to make the String]
    * [Returns the lastName and the firstName]
    *
    */
    public String toString() {
        return lastName + ", " + firstName;
    }
    /*
    *
    * [Is the equals() Method, checks if the name match with the Customer]
    * [The object Customer fullName]
    * [Returns a boolean]
    *
    */
    public boolean equals(Customer fullName) {
        if (lastName.equals(fullName.lastName) && firstName.equals(fullName.firstName)) {
            return true; //True if the name match
        }
        return false; //If don't match return false
    }
    /*
    *
    * [Is the addStore() Method, it fill the partially empty array with the CoffeeShop object name]
    * [The object CoffeeShop storeName]
    * [Fill the partially empty array]
    *
    */
    public void addStore(CoffeeShop storeName) {
        boolean found = false; //If there is not repeated StoreName.
        for (int i = 0; i < numShopVisited; i++) {
            if (shopVisited[i].getName() == storeName.getName()) {
                found = true; //If the StoreName is the same return true.
            }
        }
        if(!found) {
            if (numShopVisited < shopVisited.length) {
                shopVisited[numShopVisited] = storeName;
                numShopVisited++; //If not repeated add the StoreName to the list.
                
            }
        }
    }
    /*
    *
    * [The displayStoresVisited() method displays the partially filled array with the new values]
    * [It prints the values int the partially filled array]
    *
    */
    public void displayStoresVisited(){
        for (int i = 0; i < numShopVisited; i++) {
            System.out.println(shopVisited[i]);
        }

    }
    /*
    *
    * [The getShortestWait() method return the shortest waiting time]
    * [It uses the CoffeeShop object]
    * [Returns the shortestWait]
    *
    */
    public CoffeeShop getShortestWait() {
        if (numShopVisited == 0) {
            return null; //Return null if there is no shopVisited
        }
        CoffeeShop shortestWait = shopVisited[0];
        int smallestNumber = shortestWait.getNumOrdersPending();
        for (int i = 1; i < numShopVisited; i++) {
            int index = shopVisited[i].getNumOrdersPending();
            if (index < smallestNumber) { //An if statement to find the smallest Number
                smallestNumber = index; //If the waiting time is shorter than the index time it change positions
                shortestWait = shopVisited[i];
            }
        }
        return shortestWait;
    }
}
