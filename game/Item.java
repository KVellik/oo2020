/**
 * Item
 */
public class Item {

    private String name;

    private int durability;
    private int level;
    private double weight;
    private ItemType itemType;

    public Item(String name, ItemType itemType, double weight){
        this.name = name;
        this.itemType = itemType;
        this.weight = weight;

        this.level = 0;
        this.durability = 100;
    }

    public String toString(){
        return itemType + " named " + name;
    }
}