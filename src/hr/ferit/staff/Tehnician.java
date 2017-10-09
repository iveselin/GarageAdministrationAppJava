package hr.ferit.staff;

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
        super(employeeName, fieldOFWork, accountIBAN);
        this.numOfAprentices = numOfAprentices;
    }


    public void doWork(Car carToFix, List<Apprentice> apprentices, List<ReusableItem> reusableItems, List<ExpendableItem> expendableItems) {

        int currentNumOfApprentices = 0;
        List<Apprentice> workingApprentices = new ArrayList<>();


        for (Apprentice apprentice : apprentices) {
            if (currentNumOfApprentices < this.numOfAprentices && apprentice.getFieldOFWork() == this.getFieldOFWork() && apprentice.isAvailable()) {
                apprentice.setAvailable(false);
                workingApprentices.add(apprentice);
                currentNumOfApprentices++;
            }
        }
        if (currentNumOfApprentices < this.numOfAprentices) {
            System.out.println("Not enough apprentices, try later");
            return;
        }
        // TODO: 9.10.2017. when error return, free the apprentices...
        if (this.getFieldOFWork() == FieldOfWorkEnum.BODYWORKER)
            for (ExpendableItem expendableItem : expendableItems) {
                if (expendableItem.getQuantityLeft() < 1) {
                    System.out.println("You have to refill on your expendables first");
                    return;
                }
            }

        String outputString = String.format("Tehnician %s worked on the car and his work costs %.2f$. He also needed %d apprentice(s):",
                this.getEmployeeName(), (float) workCost, numOfAprentices);
        System.out.println(outputString);

        for (Apprentice workingApprentice : workingApprentices) {
            workingApprentice.doWork(carToFix);
            workingApprentice.setAvailable(true);
        }
        System.out.println("They used: ");
        if (this.getFieldOFWork() == FieldOfWorkEnum.BODYWORKER) {

            for (ExpendableItem expendableItem : expendableItems) {
                if (!expendableItem.beUsed(carToFix)) {
                    System.out.println("\nYou have to refill on expendables, then try to fix the car\n");
                    return;
                }

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
