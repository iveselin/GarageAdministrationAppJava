package hr.ferit.staff;

public class Apprentice extends Person {

    private boolean isAvailable;
    private final int workCost = 50;

    public Apprentice(String employeeName, FieldOfWorkEnum fieldOFWork, String accountIBAN) {
        super(employeeName, fieldOFWork, accountIBAN, (byte) 0);
        this.isAvailable = true;
    }

    @Override
    void doWork() {
        System.out.println("Apprentice worked and it costs " + workCost + "$");
        addWorkHours(1);
    }
}
