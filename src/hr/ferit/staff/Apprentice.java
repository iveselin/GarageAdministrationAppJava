package hr.ferit.staff;

import hr.ferit.working_on.Car;

public class Apprentice extends Person {

    private boolean isAvailable = true;
    private static final int workCost = 50;

    public Apprentice(String employeeName, FieldOfWorkEnum fieldOFWork, String accountIBAN) {
        super(employeeName, fieldOFWork, accountIBAN);
    }

    @Override
    public void doWork(Car carToFix) {
        String outputString = String.format("\tApprentice %s helped the tehnician and his work costs %.2f$",
                this.getEmployeeName(), (float) workCost);
        System.out.println(outputString);
        carToFix.addWorkCost(workCost);
        addWorkHours(1);
    }

    public static int getApprenticeWorkCost() {
        return workCost;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
