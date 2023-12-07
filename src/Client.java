public class Client {
    private int amountOfThingsBought;
    private double subTotal;
    public Client() {
        this.amountOfThingsBought = 0;
        this.subTotal = 0.0;
    }

    // In case of successful purchase increase total bought products
    // and add the price of the current item to the subTotal. Show a success message and the state of the basket.
    void purchase(double price) {
        amountOfThingsBought++;
        subTotal += price;
        System.out.printf(
                "\n===> Successfully added!\nYou currently have %s unit(s) in the basket, for a total cost of %.2f SEK.\n"
                , getAmountOfThingsBought(), getSubTotal()
        );
    }

    // Show the message at the end of the program. In case of purchase or if the used did not purchase products.
    public void endOfPurchase(){
        if( getAmountOfThingsBought() != 0) {
            System.out.printf("\n===> You purchased %s product(s), for a total cost of %.2f SEK.\n" +
                    "The system will now exit.\n", getAmountOfThingsBought(), getSubTotal());
        } else {
            System.out.println("\n===> You did not make a purchase today.\nSee you next time!");
        }
    }

    public int getAmountOfThingsBought() {
        return this.amountOfThingsBought;
    }

    public double getSubTotal() { // opens up the private variable, which will also be used in the main method to call all the updated price
        return this.subTotal;
    }
}

