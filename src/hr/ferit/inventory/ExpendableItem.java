package hr.ferit.inventory;

import hr.ferit.working_on.Car;

public class ExpendableItem extends Item implements WorkingItem {

    private ExpendableTypeEnum expendableType;
    private int quantityLeft;


    public ExpendableItem(String itemName, ExpendableTypeEnum expendableType) {

        super(itemName);
        this.expendableType = expendableType;

        switch (expendableType) {
            case SPRAYPAINT:
                quantityLeft = 5;
                break;
            case SANDPAPER:
                quantityLeft = 10;
                break;
            default:
                quantityLeft = 0;
                break;
        }
    }

    public int getQuantityLeft() {
        return quantityLeft;
    }

    @Override
    public boolean beUsed(Car carToBeFixed) {

        if (this.quantityLeft > 0) {

            System.out.println(String.format("\t%s was used and it costs %.2f$", expendableType, this.getUseCost()));
            carToBeFixed.addWorkCost(this.getUseCost());
            quantityLeft--;
            return true;

        } else {

            System.out.println("Oh no, there is not enough " + expendableType + ", you should refill.");
            return false;
        }

    }


    public double getUseCost() {
        switch (expendableType) {

            case SANDPAPER:
                return 0.50;

            case SPRAYPAINT:
                return 2.80;

            default:
                return 0.00;

        }
    }
}
