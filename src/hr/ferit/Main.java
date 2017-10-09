package hr.ferit;

import hr.ferit.utilities.MoneyCalculator;
import hr.ferit.working_on.Car;
import hr.ferit.working_on.WorkNeededEnum;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Garage myGarage = new Garage();
        Scanner scanner = new Scanner(System.in);
        int inputValue;
        Car inputedCar;

        System.out.println("Welcome to your garage!");

        while (true) {
            System.out.println("\nWhat would you like to do(input number in front of desired option):\n" +
                    "\t1. Input new car\n" +
                    "\t2. Calculate sallary\n" +
                    "\t3. Refill on expendables\n" +
                    "\t4. Exit");
            inputValue = Main.choseMenuItem(scanner, 4);
            switch (inputValue) {
                case 1:
                    inputedCar = Main.inputCarData(scanner);
                    myGarage.fixCar(inputedCar);
                    break;
                case 2:
                    MoneyCalculator.calculateSalary(myGarage);
                    break;
                case 3:
                    // TODO: 09/10/2017 make refil utill and use it here
                    break;
                case 4:
                    System.out.println("Thank you and goodbye!");
                    return;
            }
        }
    }

    private static int choseMenuItem(Scanner scanner, int numOfItems) {

        int inputValue;

        do {
            while (!scanner.hasNextInt()) {
                System.out.println("That's not a number!");
                scanner.next();
            }
            inputValue = scanner.nextInt();
            if (inputValue < 1 || inputValue > numOfItems) {
                System.out.println("That is out of range, try again!");
            }
        } while (inputValue < 1 || inputValue > numOfItems);

        return inputValue;
    }

    private static Car inputCarData(Scanner scanner) {

        WorkNeededEnum workNeeded = null;

        scanner.nextLine();
        System.out.println("Ok, start with car owners name:");
        String carOwnerName = scanner.nextLine().trim();

        System.out.println("Now enter owners email: ");
        String carOwnerEmail = scanner.nextLine().trim().toLowerCase();

        System.out.println("Choose what needs to be done(number in front of desired option):\n" +
                "\t1. Mechanic repair\n" +
                "\t2. Bodywork\n" +
                "\t3. Both");
        int inputValue = Main.choseMenuItem(scanner, 3);

        switch (inputValue) {
            case 1:
                workNeeded = WorkNeededEnum.MECHANIC;
                break;
            case 2:
                workNeeded = WorkNeededEnum.PAINTJOB;
                break;
            case 3:
                workNeeded = WorkNeededEnum.BOTH;
                break;
        }
        return new Car(carOwnerName, carOwnerEmail, workNeeded);
    }
}
