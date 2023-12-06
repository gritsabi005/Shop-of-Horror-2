public class Product {
    private String name;
    private double price;
    private int stock;

    public Product(String name, double price, int stock){
        this.name = name;
        this.price = price;
        this.stock = stock;
    }
    public String getName(){return name;}
    public double getPrice(){return price;}
    public int getStock(){return stock;}
    public void setPrice(double price){this.price = price;}
    void stats(){
        System.out.println(getName() + ", " + getPrice() + " SEK, " + getStock() + " left");
    }
    void inventoryMinusOne() {
        if (stock > 0) {
            stock--;
            // I tried but it only works with stock,
            // I dont understand though, why can't I use
            // getStock and have to use its original name stock
            // if the original is said to be set into private?
            // Doesnt private mean you have to access it with getters?
        } else {
            System.out.println("Sorry, " + name + " is out of stock.");
        }
    }
}
