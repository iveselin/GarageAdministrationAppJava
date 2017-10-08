package hr.ferit.staff;

import hr.ferit.working_on.Car;

abstract public class Person {

    private String employeeName;
    private FieldOfWorkEnum fieldOFWork;
    private String accountIBAN;
    private byte workHours;

    Person(String employeeName, FieldOfWorkEnum fieldOFWork, String accountIBAN, byte workHours) {
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


    abstract void doWork(Car inputCar);

    public void addWorkHours(int hoursToAdd) {
        workHours += hoursToAdd;
    }


}
