package hr.ferit.inventory;

public class Item {

    private String itemID;
    private String itemName;

    public Item(String itemID, String itemName) {
        this.itemID = itemID;
        this.itemName = itemName;
    }

    public String getItemID() {
        return itemID;
    }

    public String getItemName() {
        return itemName;
    }
}
