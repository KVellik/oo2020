import java.util.ArrayList;
import java.util.List;

/**
 * Inventory
 */
public class Inventory {
    private int inventoryMaxSize = 0;
    List<Item> inventory = new ArrayList<>();

    public Inventory(int size){
        this.inventoryMaxSize = size;
    }

    String addItem(Item item){
        if (inventory.size() <= inventoryMaxSize){
            inventory.add(item);
            return item + " added to inventory";
            //Sys.out.println(item + " added")
        } else {
            return item + " not to inventory";
            //sys.out.println(item + "not ..")
        }
    }
    // lisada removeItem, showInventory
        
      
}