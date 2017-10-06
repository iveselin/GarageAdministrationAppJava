package hr.ferit.staff;


public class Tehnician extends Person {

    private int numOfAprentices;
    private final int workCost = 120;

    public Tehnician(String employeeName, FieldOfWorkEnum fieldOFWork, String accountIBAN, int numOfAprentices) {
        super(employeeName, fieldOFWork, accountIBAN, (byte) 0);
        this.numOfAprentices = numOfAprentices;
    }

    @Override
    public void doWork() {
        // TODO: 06/10/2017 find yourself some apprentices and do the work 
        System.out.println("This tehnician needed " + numOfAprentices + " apprentice and his work costs " + workCost + "$");
        addWorkHours(1);
        
    }
}
