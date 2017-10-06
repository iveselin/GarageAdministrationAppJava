package hr.ferit.working_on;

public class Car {

    private String ownerName;
    private String ownerEmail;
    private WorkNeededEnum workNeeded;
    private double workingCost;
    private boolean isFixed;

    public Car(String ownerName, String ownerEmail, WorkNeededEnum workNeeded) {
        this.ownerName = ownerName;
        this.ownerEmail = ownerEmail;
        this.workNeeded = workNeeded;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }

    public WorkNeededEnum getWorkNeeded() {
        return workNeeded;
    }

    public double getWorkingCost() {
        return workingCost;
    }

    public boolean isFixed() {
        return isFixed;
    }

    public void setWorkingCost(double workingCost) {
        this.workingCost = workingCost;
    }

    public void setFixed(boolean fixed) {
        isFixed = fixed;
    }
}
