package hr.ferit.inventory;

public class InfrastructureItem extends Item {

    private boolean currentlyAvailable;

    public InfrastructureItem(String itemName) {
        super(itemName);
        this.currentlyAvailable = true;
    }

    public boolean isCurrentlyAvailable() {

        return currentlyAvailable;
    }

    public void setCurrentlyAvailable(boolean currentlyAvailable) {
        this.currentlyAvailable = currentlyAvailable;
    }

}
