import java.util.*;

public class Main {
    public static void main(String[] args) {
        Kund kund = new Kund(); // You create kund instance to put all your shopping inside, more like a shopping cart
        Merchandise(kund); // passing kund object to my Merchandise method
    }
    static void Merchandise(Kund kund){ // You declaring a variable name of kund from the class Kund // three instances in Merchandise
        Rabatterad mask = new Rabatterad ("Mask", 235.50, 14, 0.50);
        Merchandise plasticKnife = new Merchandise ("Plastic Knife", 45.50, 3);
        Merchandise fakeBlood = new Merchandise ("Fake Blood", 89.10, 44);

        ArrayList<Merchandise> list = new ArrayList<Merchandise>();

        list.add(mask);
        list.add(plasticKnife);
        list.add(fakeBlood);

        mask.discount(); // Adding discount to the price of the mask, by 50 percent from the first purchase and thereon

        // Calling the shop
        int chose; // initiated to create the if-statement personalizing the buyers choices
        do { // This do while will create a stats of each merchandise and will update it after every invetory is taken, until the buyer press 4, then that will close the shop inventory
            int i = 1;
            for (Merchandise item : list) {
                System.out.print(i + ". ");
                item.stats();
                i++;
            }
            System.out.println("4. Quit");
            System.out.print("Chose your option: ");
            Scanner scan = new Scanner(System.in);
            chose = scan.nextInt();
            if (chose == 1 && mask.getStock() > 0){ // You use mask.getStock to access the private int of Mask in stock above, and they are declared in the Merchandise class - why cant I use stock directly from my arraylist above Martin? Like why can't I write mask.stock() directly? Arent private variables still accessible in the same method or class?
                mask.inventoryMinusOne(); // You apply the method inventoryMinusOne() into the mask, NOT the kund, because it only checks the inventory of the merchandise, as long as there is mask in stock, the int will deduct everytime the buyer choses one
                kund.purchase(mask.getPris()); // You apply the purchase method to kund, declared in the Kund class with double price as its perimeter, and in this case, it is the price of the mask or the mask.getPris() that you get from the array

            }
            if (chose == 2 && plasticKnife.getStock() > 0){
                plasticKnife.inventoryMinusOne();
                kund.purchase(plasticKnife.getPris());
            }
            if (chose == 3 && fakeBlood.getStock() > 0){
                fakeBlood.inventoryMinusOne();
                kund.purchase(fakeBlood.getPris());
            }
        } while (chose != 4);
        System.out.println("You have bought " + kund.getAmountOfThingsBought() + " merchandise, total cost " + kund.getFinalPrice() + " SEK."); // You use get.AmountOfThingsBought() and not original variable amountOfThingsBought because the first one is the one that keeps all the changes in the inventory, and they are declared in class Kund
    }
}