public class Client {
    private int amountOfThingsBought; // in each these attributes, you will need to declare them into public getters and setters, get for renaming it so that its accessible from outside class to this class, and set is to set a value from this class to outside class
    private double finalPrice;
    Client() {
        this.amountOfThingsBought = 0;
        this.finalPrice = 0.0;
    }
    public int getAmountOfThingsBought() { // opens up the private variable above,
        return this.amountOfThingsBought; // which will also be used in the main method - to save all the chosen items before being purchased
    }
    public double getFinalPrice() { // opens up the private variable, which will also be used in the main method to call all the updated price
        return this.finalPrice;
    }
    public void setFinalPrice(double discount){
        this.finalPrice = discount;
    }
    void purchase(double priCe) { // priCe will get the price of each item in merchandise, so that double priCe will refer to price in Product class, and not kund
        amountOfThingsBought = amountOfThingsBought + 1;
        finalPrice = finalPrice + priCe; //Why is it priCe that updates the price? Because this whole line of code will save every price chosen for in the invetory in its (double priCe) variable, that means, double priCe is the one where the computer saves the updated price
    }
}

