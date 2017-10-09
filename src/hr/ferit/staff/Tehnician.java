package hr.ferit.staff;


import hr.ferit.Garage;
import hr.ferit.inventory.ExpendableItem;
import hr.ferit.inventory.ReusableItem;
import hr.ferit.inventory.ReusableTypeEnum;
import hr.ferit.working_on.Car;

import java.util.ArrayList;
import java.util.List;

public class Tehnician extends Person {

    private int numOfAprentices;
    private static final int workCost = 120;

    public static int getWorkCost() {
        return workCost;
    }

    public Tehnician(String employeeName, FieldOfWorkEnum fieldOFWork, String accountIBAN, int numOfAprentices) {
        super(employeeName, fieldOFWork, accountIBAN, (byte) 0);
        this.numOfAprentices = numOfAprentices;
    }


    public void doWork(Car carToFix, List<Apprentice> apprentices, List<ReusableItem> reusableItems, List<ExpendableItem> expendableItems) {

        int currentNumOfApprentices = 0;
        List<Apprentice> workingApprentices = new ArrayList<>();
        // TODO: 09/10/2017 if enough apprentices...
        String outputString = String.format("Tehnician %s worked on the car and his work costs %.2f$. He also needed %d apprentice(s):",
                this.getEmployeeName(), (float) workCost, numOfAprentices);
        System.out.println(outputString);

        for (Apprentice apprentice : apprentices) {

            if (currentNumOfApprentices < this.numOfAprentices && apprentice.getFieldOFWork() == this.getFieldOFWork() && apprentice.isAvailable()) {
                apprentice.setAvailable(false);
                workingApprentices.add(apprentice);
                apprentice.doWork(carToFix);
                currentNumOfApprentices++;
            }
        }

        for (Apprentice workingApprentice : workingApprentices) {
            workingApprentice.setAvailable(true);
        }
        System.out.println("They used: ");
        if (this.getFieldOFWork() == FieldOfWorkEnum.BODYWORKER) {

            for (ExpendableItem expendableItem : expendableItems) {
                expendableItem.beUsed(carToFix);
            }
            for (ReusableItem reusableItem : reusableItems) {
                if (reusableItem.getTypeEnum() != ReusableTypeEnum.WRENCH) {
                    reusableItem.beUsed(carToFix);
                }
            }
        } else {
            for (ReusableItem reusableItem : reusableItems) {
                if (reusableItem.getTypeEnum() == ReusableTypeEnum.WRENCH) {
                    reusableItem.beUsed(carToFix);
                }
            }
        }

        this.addWorkHours(1);
        carToFix.setFixed(true);
        carToFix.addWorkCost(workCost);

    }

    public int getNumOfAprentices() {
        return numOfAprentices;
    }
}
