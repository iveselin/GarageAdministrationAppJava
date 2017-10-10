package hr.ferit.utilities;

import hr.ferit.inventory.ExpendableItem;
import hr.ferit.inventory.ExpendableTypeEnum;
import hr.ferit.inventory.ReusableItem;
import hr.ferit.inventory.ReusableTypeEnum;
import hr.ferit.staff.Apprentice;
import hr.ferit.staff.FieldOfWorkEnum;
import hr.ferit.staff.Technician;

import java.util.ArrayList;
import java.util.List;

public class GarageCreationUtil {

    private GarageCreationUtil() {
    }

    public static List<Apprentice> createApprentices() {

        List<Apprentice> apprentices = new ArrayList<>();

        apprentices.add(new Apprentice("Ivan", FieldOfWorkEnum.BODYWORKER, "HR12312313"));
        apprentices.add(new Apprentice("Tomislav", FieldOfWorkEnum.BODYWORKER, "HR123456789"));
        apprentices.add(new Apprentice("John", FieldOfWorkEnum.MECHANIC, "HR12312313"));

        return apprentices;
    }

    public static List<Technician> createTehnicians() {

        List<Technician> technicians = new ArrayList<>();

        technicians.add(new Technician("Joseph", FieldOfWorkEnum.MECHANIC, "HR987654321", 1));
        technicians.add(new Technician("Mladen", FieldOfWorkEnum.BODYWORKER, "HR987654321", 2));

        return technicians;
    }

    public static List<ReusableItem> createReusableItems() {

        List<ReusableItem> reusableItems = new ArrayList<>();

        reusableItems.add(new ReusableItem("Wrench 12", 12, ReusableTypeEnum.WRENCH));
        reusableItems.add(new ReusableItem("Wrench 17", 17, ReusableTypeEnum.WRENCH));
        reusableItems.add(new ReusableItem("Hammer 0.5", 0.5, ReusableTypeEnum.HAMMER));
        reusableItems.add(new ReusableItem("Hammer 1.5", 1.5, ReusableTypeEnum.HAMMER));
        reusableItems.add(new ReusableItem("Spraygun", 1, ReusableTypeEnum.SPRAYGUN));
        reusableItems.add(new ReusableItem("Sander", 1, ReusableTypeEnum.SANDER));

        return reusableItems;
    }

    public static List<ExpendableItem> createExpendableItems() {

        List<ExpendableItem> expendableItems = new ArrayList<>();

        expendableItems.add(new ExpendableItem("Blue paint", ExpendableTypeEnum.SPRAYPAINT));
        expendableItems.add(new ExpendableItem("Sandpaper 200", ExpendableTypeEnum.SANDPAPER));

        return expendableItems;
    }
}

