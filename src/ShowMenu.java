import java.util.ArrayList;

public class ShowMenu {
    private String exitMessage = "Purchase and exit";
    private ArrayList<Product> products;
    private int menuOptions = 0, userMenuChoice;

    public ShowMenu(ArrayList<Product> products){
        this.products = products;
    }

    // Shows the menu based on the items in the list.
    // New menu items can always be added and nothing more has to be done!
    // The last option after the list is the exit. Can be changed
    public void showMenu(){
        menuOptions = 0;
        for(Product product : products){
            System.out.printf("%s. %s - on stock %s units. Price per unit: %.2f SEK\n",
                    ++menuOptions, product.getName(), product.getStock(), product.getPrice());
        }
        System.out.println(++menuOptions + ". " + exitMessage);
        System.out.print("===> Enter your option: ");
    }

    // The function is responsible about actions based on the user's valid menu choice.
    public void choiceOptions(Client client){
        // The menu choice corresponds to an index of the specific item - 1
        if(userMenuChoice > 0 && userMenuChoice <= products.size()){
            // the product in mind is put in a variable for optimization purposes (used 4 times in the following if)
            Product currentProduct = products.get(userMenuChoice - 1);
            if(currentProduct.getStock() > 0){
                currentProduct.reduceStockAfterPurchase();
                client.purchase(currentProduct.getPrice());
            } else {
                System.out.println("\n!!! Sorry, " + currentProduct.getName() + " is out of stock.");
            }
        } else if (userMenuChoice <= 0 || userMenuChoice > menuOptions){
            System.out.printf("\n!!! %s is not a valid menu choice. Please try again.\n", userMenuChoice);
        }
    }

    public int getMenuOptions() {
        return menuOptions;
    }

    public void setUserMenuChoice(int userMenuChoice) {
        this.userMenuChoice = userMenuChoice;
    }
}
