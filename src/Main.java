import java.util.*;

public class Main {
    public static void main(String[] args) {
        Client client = new Client(); // You create client instance to put all your shopping inside, more like a shopping cart
        ShopOfHorror(client); // passing client object to my Product method
    }
    // Can be read from CSV instead?
    static void ShopOfHorror(Client client){ // You declaring a variable name of client from the class Client // three instances in Product
        ArrayList<Product> list = new ArrayList<Product>();

        list.add(new Discounted("Mask", 235.50, 14, 0.50));
        list.add(new Product("Plastic Knife", 45.50, 3));
        list.add(new Product("Fake Blood", 89.10, 44));

        ShowMenu menu = new ShowMenu(list);

        // Calling the shop
        int menuChoice; // initiated to create the if-statement personalizing the buyers choices
        do { // This do while will create a stats of each product and will update it after a unit from the stock is taken, until the buyer press 4*, then that will close the shop inventory
            // *The exit condition may change and be more than 4.
            // The menu is scalable and outside main method now.
            menu.showMenu();
            Scanner scan = new Scanner(System.in);
            menuChoice = scan.nextInt();
            menu.setUserMenuChoice(menuChoice);
            menu.choiceOptions(client);
        } while (menuChoice != menu.getMenuOptions());
        client.endOfPurchase(); // You use get.AmountOfThingsBought() and not original variable amountOfThingsBought because the first one is the one that keeps all the changes in the inventory, and they are declared in class Client
    }
}