public class Discounted extends Product {
    private double discountInPercent;

    public Discounted(String name, double price, int stock, double discountInPercent){
        super(name, price, stock);
        this.discountInPercent = discountInPercent;
        // Discount can be applied only on items that cost 50 SEK or more.
        if (price >= 50.00)
            discount();
    }

    // set the discounted price of the item.
    // NB the percent works only with values between 0 and 1!
    public void discount(){
        double regularPrice = getPrice(), newPrice;
        newPrice = regularPrice -(getPrice() * getDiscountInPercent());
        setPrice(newPrice);
    }

    public double getDiscountInPercent(){
        return this.discountInPercent;
    }
}