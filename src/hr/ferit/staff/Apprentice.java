package hr.ferit.staff;

import hr.ferit.working_on.Car;

public class Apprentice extends Person {

    private boolean isAvailable;
    private final int workCost = 50;

    public Apprentice(String employeeName, FieldOfWorkEnum fieldOFWork, String accountIBAN) {
        super(employeeName, fieldOFWork, accountIBAN, (byte) 0);
        this.isAvailable = true;
    }

    @Override
    void doWork(Car carToFix) {
        String outputString = String.format("\tApprentice %s helped the tehnician and his work costs %d",
                this.getEmployeeName(), workCost);
        System.out.println(outputString);
        addWorkHours(1);
    }
}
