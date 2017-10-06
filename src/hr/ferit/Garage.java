package hr.ferit;

import hr.ferit.inventory.*;
import hr.ferit.staff.Apprentice;
import hr.ferit.staff.FieldOfWorkEnum;
import hr.ferit.staff.Tehnician;
import hr.ferit.working_on.Car;

import java.util.ArrayList;
import java.util.List;

public class Garage {

    private List<Apprentice> apprentices = new ArrayList<>();
    private List<Tehnician> tehnicians = new ArrayList<>();
    private List<ReusableItem> reusableItems = new ArrayList<>();
    private List<ExpendableItem> expendableItems = new ArrayList<>();
    private InfrastructureItem placeToItem = new InfrastructureItem("COBE mechanic and bodyshop");

    public Garage() {

        apprentices.add(new Apprentice("Ivan", FieldOfWorkEnum.BODYWORKER, "HR12312313"));
        apprentices.add(new Apprentice("Tomislav", FieldOfWorkEnum.BODYWORKER, "HR123456789"));
        apprentices.add(new Apprentice("John", FieldOfWorkEnum.MECHANIC, "HR12312313"));

        tehnicians.add(new Tehnician("Joseph", FieldOfWorkEnum.MECHANIC, "HR987654321", 1));
        tehnicians.add(new Tehnician("Mladen", FieldOfWorkEnum.BODYWORKER, "HR987654321", 2));

        reusableItems.add(new ReusableItem("Wrench 12", 12, ReusableTypeEnum.WRENCH));
        reusableItems.add(new ReusableItem("Wrench 17", 17, ReusableTypeEnum.WRENCH));
        reusableItems.add(new ReusableItem("Hammer 0.5", 0.5, ReusableTypeEnum.HAMMER));
        reusableItems.add(new ReusableItem("Hammer 1.5", 1.5, ReusableTypeEnum.HAMMER));
        reusableItems.add(new ReusableItem("Spraygun", 1, ReusableTypeEnum.SPRAYGUN));
        reusableItems.add(new ReusableItem("Sander", 1, ReusableTypeEnum.SANDER));

        expendableItems.add(new ExpendableItem("Blue paint", ExpendableTypeEnum.SPRAYPAINT));
        expendableItems.add(new ExpendableItem("Sandpaper 200", ExpendableTypeEnum.SANDPAPER));

    }

    public void fixCar(Car inputCar) {

    }
}
