package hr.ferit.inventory;

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


    @Override
    public void beUsed() {

        System.out.println(typeEnum + "was used and it costs" + this.getUseCost());

    }

    public double getUseCost() {
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
