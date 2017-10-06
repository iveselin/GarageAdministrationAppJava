package hr.ferit.staff;

public class Apprentice extends Person {

    private boolean isAvailable;

    public Apprentice(String employeeName, FieldOfWorkEnum fieldOFWork, String accountIBAN, byte workHours, boolean isAvailable) {
        super(employeeName, fieldOFWork, accountIBAN, workHours);
        this.isAvailable = isAvailable;
    }

    @Override
    void doWork() {
        // TODO: 05/10/2017 implement working method
    }
}
