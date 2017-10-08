package hr.ferit.staff;


import hr.ferit.working_on.Car;

public class Tehnician extends Person {

    private int numOfAprentices;
    private final int workCost = 120;

    public Tehnician(String employeeName, FieldOfWorkEnum fieldOFWork, String accountIBAN, int numOfAprentices) {
        super(employeeName, fieldOFWork, accountIBAN, (byte) 0);
        this.numOfAprentices = numOfAprentices;
    }

    @Override
    public void doWork(Car carToFix) {
        // TODO: 8.10.2017. find apprentice!!!

        String outputString = String.format("Tehnician %s worked on the car and his work costs %d. He also needed %d apprentices:",
                this.getEmployeeName(), workCost, numOfAprentices);
        System.out.println(outputString);
        this.addWorkHours(1);
        carToFix.setFixed(true);

    }
}
