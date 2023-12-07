public class Discounted extends Product {
    private double discountInPercent;
    public Discounted(String name, double price, int stock, double discountInPercent){
        super(name, price, stock);
        this.discountInPercent = discountInPercent;
        if (price >= 50.00)
            // Adding discount to the price of the mask, by 50 percent from the first purchase and thereon
            discount();
    }
    public double getDiscountInPercent(){
        return this.discountInPercent;
    }

    public void discount(){ // discount will be used in the mask.discount, plasticKnife.discount and fakeBlood.discount just the way purchase method is made and used in the kund.purchase because they  follow the instances upon which they are built for
        // you get the price that this method is applied to, and if the price of the item is above 50.00, then it will apply the discount (specified in the main class as 50 percent in mask)
        setPrice(getPrice() * getDiscountInPercent()); // set the new price (the price of the item this method is applied to times 50 percent as stated in the main class)
    }
}