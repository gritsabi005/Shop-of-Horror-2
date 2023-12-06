import java.util.ArrayList;

public class ShowMenu {
    private String exitMessage = "Purchase and exit";
    private ArrayList<Product> products;
    private int menuOptions = 0, menuChoice;

    public ShowMenu(ArrayList<Product> products){
        this.products = products;
    }

    //new menu items can always be added!
    public void showMenu(){
        menuOptions = 0;
        for(Product product : products){
            System.out.println(++menuOptions + ". " +
                    product.getName() + " - " +
                    "on stock: " + product.getStock() +
                    " units. Price per unit: " + product.getPrice() + " SEK");
        }
        System.out.println(++menuOptions + ". " + exitMessage);
        System.out.print("Chose your option: ");
    }

    public int getMenuOptions() {
        return menuOptions;
    }
}
