package hr.ferit.utilities;

import hr.ferit.Garage;
import hr.ferit.inventory.ExpendableItem;
import hr.ferit.staff.Apprentice;
import hr.ferit.staff.Person;
import hr.ferit.staff.Tehnician;

import java.util.List;

public class MoneyCalculator {

    private static final double costOfPaint = 1.89;
    private static final double costOfSandpaper = 0.45;

    private MoneyCalculator() {
    }

    public static void refillExpendables(Garage currentGarage) {

        for (ExpendableItem expendable : currentGarage.getExpendableItems()) {

            double costOfRefill = 0;

            if (expendable.getQuantityLeft() < 1) {

                switch (expendable.getExpendableType()) {

                    case SANDPAPER:
                        costOfRefill += 10 * costOfSandpaper;
                        expendable.addQuantity(10);
                        currentGarage.changeBankBalance(-costOfRefill);
                        break;

                    case SPRAYPAINT:
                        costOfRefill += 5 * costOfPaint;
                        expendable.addQuantity(5);
                        currentGarage.changeBankBalance(-costOfRefill);
                        break;
                }
            }
        }
    }

    public static void calculateSalary(Garage currentGarage) {

        double salary;

        for (Tehnician tehnician : currentGarage.getTehnicians()) {

            salary = tehnician.getWorkHours() * Tehnician.getWorkCost() * 0.7;

            System.out.println(String.format("%s worked %d hour(s), and his salary sums up to: \t%.2f$",
                    tehnician.getEmployeeName(), tehnician.getWorkHours(), salary));

            currentGarage.changeBankBalance(-salary);
            tehnician.resetWorkHours();
        }
        for (Apprentice apprentice : currentGarage.getApprentices()) {

            salary = apprentice.getWorkHours() * Apprentice.getApprenticeWorkCost() * 0.7;

            System.out.println(String.format("%s worked %d hour(s), and his salary sums up to: \t%.2f$",
                    apprentice.getEmployeeName(), apprentice.getWorkHours(), salary));

            currentGarage.changeBankBalance(-salary);
            apprentice.resetWorkHours();
        }

    }
}
