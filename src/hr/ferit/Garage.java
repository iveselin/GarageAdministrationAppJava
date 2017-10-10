package hr.ferit;

import hr.ferit.inventory.*;
import hr.ferit.staff.Apprentice;
import hr.ferit.staff.FieldOfWorkEnum;
import hr.ferit.staff.Technician;
import hr.ferit.utilities.GarageCreationUtil;
import hr.ferit.working_on.Car;

import java.util.ArrayList;
import java.util.List;

public class Garage {

    private List<Apprentice> apprentices = new ArrayList<>();
    private List<Technician> technicians = new ArrayList<>();
    private List<ReusableItem> reusableItems = new ArrayList<>();
    private List<ExpendableItem> expendableItems = new ArrayList<>();
    private InfrastructureItem placeToWork = new InfrastructureItem("COBE mechanic and bodyshop");
    private double bankBalance;

    public Garage() {

        apprentices = GarageCreationUtil.createApprentices();
        technicians = GarageCreationUtil.createTehnicians();
        reusableItems = GarageCreationUtil.createReusableItems();
        expendableItems = GarageCreationUtil.createExpendableItems();
        bankBalance = 10000;
        placeToWork.setCurrentlyAvailable(false);

    }

    public void fixCar(Car inputCar) {

        switch (inputCar.getWorkNeeded()) {

            case MECHANIC:
                for (Technician technician : technicians) {

                    if (technician.getFieldOFWork() == FieldOfWorkEnum.MECHANIC) {
                        technician.doWork(inputCar, apprentices, reusableItems, expendableItems);
                        break;
                    }
                }
                break;

            case PAINTJOB:
                for (Technician technician : technicians) {

                    if (technician.getFieldOFWork() == FieldOfWorkEnum.BODYWORKER) {
                        technician.doWork(inputCar, apprentices, reusableItems, expendableItems);
                        break;
                    }
                }
                break;

            case BOTH:
                for (Technician technician : technicians) {

                    if (technician.getFieldOFWork() == FieldOfWorkEnum.BODYWORKER) {
                        technician.doWork(inputCar, apprentices, reusableItems, expendableItems);
                        break;
                    }
                }
                for (Technician technician : technicians) {

                    if (technician.getFieldOFWork() == FieldOfWorkEnum.MECHANIC) {
                        technician.doWork(inputCar, apprentices, reusableItems, expendableItems);
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
            System.out.println("We don't have enough technicians, try later");
        }
    }

    public List<Apprentice> getApprentices() {
        return apprentices;
    }

    public List<Technician> getTechnicians() {
        return technicians;
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
