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

        switch (inputCar.getWorkNeeded()) {
            case MECHANIC:
                // TODO: 06/10/2017 find a mechanic(he will find apprentice), then give them the car so they can fix it
                for (Tehnician tehnician : tehnicians) {

                    if (tehnician.getFieldOFWork() == FieldOfWorkEnum.MECHANIC) {
                        tehnician.doWork();
                    }
                }
                break;
            case PAINTJOB:
                // TODO: 06/10/2017 find bodyworker and his apprentice, give them the car so they fix it
                break;
            case BOTH:
                // TODO: 06/10/2017 maybe delete this from project
                break;
            default:
                // TODO: 06/10/2017 what if car is null??
        }
    }
}
