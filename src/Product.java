public class Product {
    private String name;
    private double price;
    private int stock;

    public Product(String name, double price, int stock){
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    void reduceStockAfterPurchase() {
        stock--;
    }

    public int getStock(){return stock;}

    public String getName(){return name;}

    public double getPrice(){return price;}

    public void setPrice(double price){this.price = price;}
}
