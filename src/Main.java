import java.util.*;

public class Main {
    public static void main(String[] args) {
        Client client = new Client(); // You create client instance to put all your shopping inside, more like a shopping cart
        Merchandise(client); // passing client object to my Product method
    }
    static void Merchandise(Client client){ // You declaring a variable name of client from the class Client // three instances in Product
        Discounted mask = new Discounted("Mask", 235.50, 14, 0.50);
        Product plasticKnife = new Product("Plastic Knife", 45.50, 3);
        Product fakeBlood = new Product("Fake Blood", 89.10, 44);

        ArrayList<Product> list = new ArrayList<Product>();

        list.add(mask);
        list.add(plasticKnife);
        list.add(fakeBlood);
        ShowMenu menu = new ShowMenu(list);

        mask.discount(); // Adding discount to the price of the mask, by 50 percent from the first purchase and thereon

        // Calling the shop
        int chose; // initiated to create the if-statement personalizing the buyers choices
        do { // This do while will create a stats of each merchandise and will update it after every invetory is taken, until the buyer press 4, then that will close the shop inventory
            // The exit condition may change and be more than 4.
            // The menu is scalable and outside main method now.
            menu.showMenu();
            Scanner scan = new Scanner(System.in);
            chose = scan.nextInt();
            if (chose == 1 && mask.getStock() > 0){ // You use mask.getStock to access the private int of Mask in stock above, and they are declared in the Product class - why cant I use stock directly from my arraylist above Martin? Like why can't I write mask.stock() directly? Arent private variables still accessible in the same method or class?
                mask.inventoryMinusOne(); // You apply the method inventoryMinusOne() into the mask, NOT the client, because it only checks the inventory of the merchandise, as long as there is mask in stock, the int will deduct everytime the buyer choses one
                client.purchase(mask.getPrice()); // You apply the purchase method to client, declared in the Client class with double price as its perimeter, and in this case, it is the price of the mask or the mask.getPris() that you get from the array

            }
            if (chose == 2 && plasticKnife.getStock() > 0){
                plasticKnife.inventoryMinusOne();
                client.purchase(plasticKnife.getPrice());
            }
            if (chose == 3 && fakeBlood.getStock() > 0){
                fakeBlood.inventoryMinusOne();
                client.purchase(fakeBlood.getPrice());
            }
        } while (chose != 4);
        System.out.println("You have bought " + client.getAmountOfThingsBought() + " products, total cost " + client.getFinalPrice() + " SEK."); // You use get.AmountOfThingsBought() and not original variable amountOfThingsBought because the first one is the one that keeps all the changes in the inventory, and they are declared in class Client
    }
}