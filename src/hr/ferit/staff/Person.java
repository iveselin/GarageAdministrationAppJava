package hr.ferit.staff;

abstract public class Person {

    private String employeeName;
    private FieldOfWorkEnum fieldOFWork;
    private String accountIBAN;
    private byte workHours;

    public Person(String employeeName, FieldOfWorkEnum fieldOFWork, String accountIBAN, byte workHours) {
        this.employeeName = employeeName;
        this.fieldOFWork = fieldOFWork;
        this.accountIBAN = accountIBAN;
        this.workHours = workHours;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public FieldOfWorkEnum getFieldOFWork() {
        return fieldOFWork;
    }

    public String getAccountIBAN() {
        return accountIBAN;
    }

    public byte getWorkHours() {
        return workHours;
    }


    abstract void doWork();

    public void addWorkHours(int hoursToAdd) {
        workHours += hoursToAdd;
    }


}
