package hr.ferit.inventory;

public class ReusableItem extends Item implements WorkingItem{

    private double sizeOfItem;

    public ReusableItem(String itemID, String itemName, double sizeOfItem) {
        super(itemID, itemName);
        this.sizeOfItem = sizeOfItem;
    }

    public double getSizeOfItem() {
        return sizeOfItem;
    }

    @Override
    public void beUsed() {
        // TODO: 05/10/2017 implement how is this going to affect object state
    }
}
