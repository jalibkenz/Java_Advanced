package YantraWorks;

import java.util.Scanner;

public class TestYantraApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create objects
        Development dev = new Development("Test Yantra", 500);
        Testing test = new Testing("Test Yantra", 750);
        Services serv = new Services("Test Yantra");
        Institute inst = new Institute("Test Yantra", 1000);

        dev.displayCompanyInfo();

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Development Department");
            System.out.println("2. Testing Department");
            System.out.println("3. Services Department");
            System.out.println("4. Institute");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    dev.showDetails();
                    break;
                case 2:
                    test.showDetails();
                    break;
                case 3:
                    serv.showDetails();
                    break;
                case 4:
                    inst.showDetails();
                    break;
                case 5:
                    System.out.println("Thank you for visiting Test Yantra!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice, try again.");
            }
        }
    }
}
