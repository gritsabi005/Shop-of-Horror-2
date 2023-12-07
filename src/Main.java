import java.util.*;

public class Main {
    public static void main(String[] args) {
        // The instance of a client is considered to be like a shopping basket based on task description.
        Client client = new Client();
        ShopOfHorror(client);
    }

    static void ShopOfHorror(Client client){
        // Generating a list with hardcoded products.
        // No need to give unique variable names to the products,
        // they will be accessed via their index.
        ArrayList<Product> list = new ArrayList<>();
        list.add(new Discounted("Mask (green)", 235.50, 14, 0.50));
        list.add(new Discounted("Mask (purple)", 235.50, 6, 0.20));
        list.add(new Product("Plastic Knife", 45.50, 3));
        list.add(new Product("Fake Blood", 89.10, 21));

        // the list of items is important for the menu and thus must be sent for smoother process.
        ShowMenu menu = new ShowMenu(list);

        int menuChoice;
        // Show the menu and let the user choose an item until Exit is chosen
        do {
            // Call the menu. It is a list with all the items, but it starts from 1
            // unlike list's indexes which start from 0.
            System.out.println();
            menu.showMenu();
            Scanner scan = new Scanner(System.in);
            try{
                menuChoice = scan.nextInt();
                menu.setUserMenuChoice(menuChoice);
                // What will the program's reaction to the user's input be
                // depends mostly on choiceOptions().
                menu.choiceOptions(client);
            } catch (Exception e){
                System.out.println("\n!!! Invalid menu choice! Please try again.");
                // In order to keep the program running in case of wrong input,
                // we want to give menu choice a passing but out of scope value.
                menuChoice = menu.getMenuOptions() + 1;
            }
        } while (menuChoice != menu.getMenuOptions());
        // Shows the exit message with purchase info for the client.
        client.endOfPurchase();
    }
}