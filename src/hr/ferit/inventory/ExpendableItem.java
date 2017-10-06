package hr.ferit.inventory;

public class ExpendableItem extends Item implements WorkingItem{
    private double quantityPercentageLeft;

    public ExpendableItem(String itemID, String itemName, double quantityPercentageLeft) {
        super(itemID, itemName);
        this.quantityPercentageLeft = quantityPercentageLeft;
    }

    public double getQuantityPercentageLeft() {
        return quantityPercentageLeft;
    }

    @Override
    public void beUsed() {
        // TODO: 05/10/2017 implement how is this going to affect object state
    }
}
