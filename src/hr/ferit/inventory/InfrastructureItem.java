package hr.ferit.inventory;

public class InfrastructureItem extends Item {

    private boolean currentlyAvailible;

    public InfrastructureItem(String itemID, String itemName, boolean currentlyAvailible) {
        super(itemID, itemName);
        this.currentlyAvailible = currentlyAvailible;
    }

    public boolean isCurrentlyAvailible() {
        return currentlyAvailible;
    }

}
