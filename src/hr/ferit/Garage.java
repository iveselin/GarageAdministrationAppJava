package hr.ferit;

import hr.ferit.inventory.*;
import hr.ferit.staff.Apprentice;
import hr.ferit.staff.FieldOfWorkEnum;
import hr.ferit.staff.Tehnician;
import hr.ferit.utilities.GarageCreationUtil;
import hr.ferit.working_on.Car;

import java.util.ArrayList;
import java.util.List;

public class Garage {

    private List<Apprentice> apprentices = new ArrayList<>();
    private List<Tehnician> tehnicians = new ArrayList<>();
    private List<ReusableItem> reusableItems = new ArrayList<>();
    private List<ExpendableItem> expendableItems = new ArrayList<>();
    private InfrastructureItem placeToWork = new InfrastructureItem("COBE mechanic and bodyshop");
    private double bankBalance;

    public Garage() {

        apprentices = GarageCreationUtil.createApprentices();
        tehnicians = GarageCreationUtil.createTehnicians();
        reusableItems = GarageCreationUtil.createReusableItems();
        expendableItems = GarageCreationUtil.createExpendableItems();
        bankBalance = 10000;
        placeToWork.setCurrentlyAvailable(false);

    }

    public void fixCar(Car inputCar) {

        switch (inputCar.getWorkNeeded()) {

            case MECHANIC:
                for (Tehnician tehnician : tehnicians) {

                    if (tehnician.getFieldOFWork() == FieldOfWorkEnum.MECHANIC) {
                        tehnician.doWork(inputCar, apprentices, reusableItems, expendableItems);
                        break;
                    }
                }
                break;

            case PAINTJOB:
                for (Tehnician tehnician : tehnicians) {

                    if (tehnician.getFieldOFWork() == FieldOfWorkEnum.BODYWORKER) {
                        tehnician.doWork(inputCar, apprentices, reusableItems, expendableItems);
                        break;
                    }
                }
                break;

            case BOTH:
                for (Tehnician tehnician : tehnicians) {

                    if (tehnician.getFieldOFWork() == FieldOfWorkEnum.BODYWORKER) {
                        tehnician.doWork(inputCar, apprentices, reusableItems, expendableItems);
                        break;
                    }
                }
                for (Tehnician tehnician : tehnicians) {

                    if (tehnician.getFieldOFWork() == FieldOfWorkEnum.MECHANIC) {
                        tehnician.doWork(inputCar, apprentices, reusableItems, expendableItems);
                        break;
                    }
                }
                break;

            default:
                System.out.println("That is a mistake, the car is empty");
        }
        if (inputCar.isFixed()) {

            System.out.println(String.format("The car is fixed, here is the final cost: %.2f$", inputCar.getWorkingCost()));
            this.changeBankBalance(inputCar.getWorkingCost());

            System.out.println(String.format("You should contact %s, here is his email: %s",
                    inputCar.getOwnerName(), inputCar.getOwnerEmail()));

        } else {
            System.out.println("We don't have enough tehnicians, try later");
        }
    }

    public List<Apprentice> getApprentices() {
        return apprentices;
    }

    public List<Tehnician> getTehnicians() {
        return tehnicians;
    }

    public double getBankBalance() {
        return bankBalance;
    }

    public void changeBankBalance(double bankBalance) {
        this.bankBalance += bankBalance;
    }

    public List<ExpendableItem> getExpendableItems() {
        return expendableItems;
    }
}
