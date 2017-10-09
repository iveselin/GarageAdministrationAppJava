package hr.ferit.inventory;

import hr.ferit.working_on.Car;

public class ReusableItem extends Item implements WorkingItem {

    private double sizeOfItem;

    private ReusableTypeEnum typeEnum;

    private double useCost;

    public ReusableItem(String itemName, double sizeOfItem, ReusableTypeEnum typeEnum) {
        super(itemName);
        this.sizeOfItem = sizeOfItem;
        this.typeEnum = typeEnum;
    }

    public double getSizeOfItem() {
        return sizeOfItem;
    }


    public ReusableTypeEnum getTypeEnum() {
        return typeEnum;
    }

    @Override
    public boolean beUsed(Car carToBeFixed) {

        System.out.println(String.format("\t%s was used and it costs %.2f$", this.getItemName(), this.getUseCost()));
        carToBeFixed.addWorkCost(this.getUseCost());

        return true;

    }

    private double getUseCost() {
        switch (typeEnum) {
            case HAMMER:
                useCost = 0.02;
                break;
            case SANDER:
                useCost = 0.10;
                break;
            case WRENCH:
                useCost = 0.05;
                break;
            case SPRAYGUN:
                useCost = 0.18;
                break;
            default:
                useCost = 0.00;
                break;
        }
        return useCost;
    }
}
