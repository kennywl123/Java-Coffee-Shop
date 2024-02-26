public class Drink {
    private String drinkName; //Assign drinkName.
    private int listSize = 100; //Set list length to 100. 
    private Ingredient [] ingredientsList = new Ingredient [listSize]; //Create a list of Ingredients objects.
    private int index = 0; //Assign index.
    /*
    *
    * [Is the constructor Method and initializes a newly created object of that type]
    * [It takes as parameter a String drinkname]
    * [It returns the Drink object]
    *
    */
    public Drink(String drinkname) {
        this.drinkName = drinkname;
    }
    /*
    *
    * [Is the method addIngredient(), that adds the ingredient to the ingredientsList]
    * [It takes as parameter the object Ingredient ingredient]
    *
    */
    public void addIngredient(Ingredient ingredient) {
        ingredientsList[index] = ingredient;
        index++;
    }
    /*
    *
    * [Is the method calculateCost() of each drink]
    * [It returns the sum of all ingredients for each drink]
    *
    */
    public double calculateCost() {
        double totalCost = 0;
        for (int i = 0; i < index; i++){
            totalCost += ingredientsList[i].getCost();
        }
        return totalCost;
    }
    /*
    *
    * [Is the toString() Method and helps to make the String]
    * [It returns a String]
    *
    */
    public String toString() {
        StringBuilder drinkString = new StringBuilder(); //It creates a String builder
        drinkString.append(drinkName).append(", Ingredients:\n");
        for (int i = 0; i < index; i++) { //A for loop to print every ingredient of the list
            drinkString.append("\t").append(ingredientsList[i].toString()).append("\n");
        }
        return drinkString.toString(); //Returns the values found in the list and trasform it to Strings
    }
}
