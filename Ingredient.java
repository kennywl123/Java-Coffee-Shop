public class Ingredient {
    private String ingredientName; //Assign ingredientName.
    private int ingredientAmount; //Ingredient Amount in ml.
    private double pricePerLitre; //Price per litre.
    /*
    *
    * [Is the constructor Method and initializes a newly created object of that type]
    * [It takes as parameters a String ingredientName, int ingredientAmount, double pricePerLitre]
    * [It returns the Ingredient object]
    *
    */
    public Ingredient(String ingredientName, int ingredientAmount, double pricePerLitre) {
        this.ingredientName = ingredientName;
        this.ingredientAmount = ingredientAmount;
        this.pricePerLitre = pricePerLitre;
    }
    /*
    *
    * [Is the getCost() Method, calculates the cost per ingredient]
    * [Takes as input ingredientAmount and pricePerLitre]
    * [Returns a double]
    *
    */
    public double getCost() {
        return ingredientAmount * (pricePerLitre / 1000); //1L == 1000ml
    }
  /*
    *
    * [Is the toString() Method and helps to make the String]
    * [Returnsa String with the ingredientName, ingredientAmount, pricePerLitre]
    *
    */
    public String toString() {
        return ingredientName + ", " + ingredientAmount + " mls, " + "$" + pricePerLitre + "/L";
    }
}
