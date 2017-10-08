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

    public Garage() {

        apprentices = GarageCreationUtil.createApprentices();
        tehnicians = GarageCreationUtil.createTehnicians();
        reusableItems = GarageCreationUtil.createReusableItems();
        expendableItems = GarageCreationUtil.createExpendableItems();

    }

    public void fixCar(Car inputCar) {
        // TODO: 8.10.2017. managed to get tehnicians, think about how to find apprentices
        switch (inputCar.getWorkNeeded()) {

            case MECHANIC:
                for (Tehnician tehnician : tehnicians) {

                    if (tehnician.getFieldOFWork() == FieldOfWorkEnum.MECHANIC) {
                        tehnician.doWork(inputCar);
                        break;
                    }
                }
                break;

            case PAINTJOB:
                for (Tehnician tehnician : tehnicians) {

                    if (tehnician.getFieldOFWork() == FieldOfWorkEnum.BODYWORKER) {
                        tehnician.doWork(inputCar);
                        break;
                    }
                }
                break;

            case BOTH:
                for (Tehnician tehnician : tehnicians) {

                    if (tehnician.getFieldOFWork() == FieldOfWorkEnum.BODYWORKER) {
                        tehnician.doWork(inputCar);
                        break;
                    }
                }
                for (Tehnician tehnician : tehnicians) {

                    if (tehnician.getFieldOFWork() == FieldOfWorkEnum.MECHANIC) {
                        tehnician.doWork(inputCar);
                        break;
                    }
                }
                break;

            default:
                System.out.println("That is a mistake, the car is empty");
        }
        if (inputCar.isFixed()) {
            System.out.println("The car is fixed, here is the final cost:");
            // TODO: 8.10.2017. calculate cost of repair
        } else {
            System.out.println("We dont have enough tehnicians, try later");
        }
    }
}
