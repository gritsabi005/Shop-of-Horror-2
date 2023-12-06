import java.util.*;
public class Merchandise {
    private String name;
    private double pris;
    private int stock;

    public Merchandise(String name, double pris, int stock){
        this.name = name;
        this.pris = pris;
        this.stock = stock;
    }
    public String getName(){return name;}
    public double getPris(){return pris;}
    public int getStock(){return stock;}
    public void setPris(double price){this.pris = price;}
    void stats(){
        System.out.println(getName() + ", " + getPris() + " SEK, " + getStock() + " left");
    }
    void inventoryMinusOne() {
        if (stock > 0) {
            stock--; // I tried but it only works with stock, I dont understand though, why can't I use getStock and have to use its original name stock if the original is said to be set into private? Doesnt private mean you have to access it with getters?
        } else {
            System.out.println("Sorry, " + name + " is out of stock.");
        }
    }
}
