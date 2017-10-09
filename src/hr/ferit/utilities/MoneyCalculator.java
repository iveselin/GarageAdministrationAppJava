package hr.ferit.utilities;

import hr.ferit.Garage;
import hr.ferit.staff.Apprentice;
import hr.ferit.staff.Person;
import hr.ferit.staff.Tehnician;

import java.util.List;

public class MoneyCalculator {

    private MoneyCalculator() {
    }

    public static double calculateCost() {

        return 0.00;
    }

    public static void calculateSalary(Garage currentGarage) {
        double salary;
        System.out.println(String.format("Current bank balance: %.2f$\n", currentGarage.getBankBalance()));
        for (Tehnician tehnician : currentGarage.getTehnicians()) {

            salary = tehnician.getWorkHours() * Tehnician.getWorkCost() * 0.7;

            System.out.println(String.format("%s worked %d hour(s), and his salary sums up to: \t%.2f$",
                    tehnician.getEmployeeName(), tehnician.getWorkHours(), salary));

            currentGarage.changeBankBalance(-salary);
        }
        for (Apprentice apprentice : currentGarage.getApprentices()) {

            salary = apprentice.getWorkHours() * Apprentice.getApprenticeWorkCost() * 0.7;

            System.out.println(String.format("%s worked %d hour(s), and his salary sums up to: \t%.2f$",
                    apprentice.getEmployeeName(), apprentice.getWorkHours(), salary));

            currentGarage.changeBankBalance(-salary);
        }
        System.out.println(String.format("\nBank balance after paying: %.2f$", currentGarage.getBankBalance()));

    }
}
