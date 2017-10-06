package hr.ferit.staff;

public class Tehnician extends Person {

    private int numOfAprentices;

    public Tehnician(String employeeName, FieldOfWorkEnum fieldOFWork, String accountIBAN, byte workHours, int numOfAprentices) {
        super(employeeName, fieldOFWork, accountIBAN, workHours);
        this.numOfAprentices = numOfAprentices;
    }

    @Override
    void doWork() {
        // TODO: 05/10/2017 implement what a certified tehnician does
    }
}
