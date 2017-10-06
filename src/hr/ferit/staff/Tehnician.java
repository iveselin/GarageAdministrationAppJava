package hr.ferit.staff;


public class Tehnician extends Person {

    private int numOfAprentices;
    private final int workCost = 120;

    public Tehnician(String employeeName, FieldOfWorkEnum fieldOFWork, String accountIBAN, int numOfAprentices) {
        super(employeeName, fieldOFWork, accountIBAN, (byte) 0);
        this.numOfAprentices = numOfAprentices;
    }

    @Override
    void doWork() {
        System.out.println("This tehnician needed " + numOfAprentices + "and his work costs " + workCost + "$");
        System.out.println();
        addWorkHours(1);
    }
}
