public class Discounted extends Product {
    private double discountInPercent;
    public Discounted(String name, double price, int stock, double discountInPercent){
        super(name, price, stock);
        this.discountInPercent = discountInPercent;
        if (price >= 50.00)
            discount();
    }
    public double getDiscountInPercent(){
        return this.discountInPercent;
    }

    public double discount(){ // discount will be used in the mask.discount, plasticKnife.discount and fakeBlood.discount just the way purchase method is made and used in the kund.purchase because they  follow the instances upon which they are built for
        if (getPrice() >= 50.00){ // you get the price that this method is applied to, and if the price of the item is above 50.00, then it will apply the discount (specified in the main class as 50 percent in mask)
            setPrice(getPrice() * getDiscountInPercent()); // set the new price (the price of the item this method is applied to times 50 percent as stated in the main class)
        }
        return getPrice(); // You return the getters and not the setters, because setters do not return
    }
}
/*
comparison
    void purchase(double priCe) { // purchase bakal di pake di kund.purchase, yang dalem purchasenya itu int double priCe, apa itu int double priCe?, priCe will access the price of each item in merchandise, so that double priCe will refer to price in Product class, and not kund
        amountOfThingsBought = amountOfThingsBought + 1;
        finalPrice = finalPrice + priCe; // plasticKnife.getpris nya di ambil, di tambahkan ke priCe, jadinya 0 = 0 + 238.50 equals to finalPrixe 238.50. But the Discounted wants only to have the price in the merchandise so you
    }
 */
