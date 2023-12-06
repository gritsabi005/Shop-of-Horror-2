import java.util.ArrayList;

public class ShowMenu {
    private String exitMessage = "Purchase and exit", addProduct, addDiscountProduct;
    private ArrayList<Product> products;
    private int menuOptions = 0;
    private int userMenuChoice;

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
    public void setUserMenuChoice(int userMenuChoice) {
        this.userMenuChoice = userMenuChoice;
    }

    public void choiceOptions(Client client){
        if(userMenuChoice > 0 && userMenuChoice <= products.size()){
            products.get(userMenuChoice -1).inventoryMinusOne(); // You apply the method inventoryMinusOne() into the mask, NOT the client, because it only checks the inventory of the merchandise, as long as there is mask in stock, the int will deduct everytime the buyer choses one
            client.purchase(products.get(userMenuChoice -1).getPrice());
        }
    }

}
