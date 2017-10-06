package hr.ferit.inventory;

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
                quantityLeft = 2;
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
    public void beUsed() {
        System.out.println(expendableType + "was used and it costs " + this.getUseCost());
        quantityLeft--;
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
