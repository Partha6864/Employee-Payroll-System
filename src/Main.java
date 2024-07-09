import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PayrollSystem payrollSystem = new PayrollSystem();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nPayroll System Menu:");
            System.out.println("1. Add Employee");
            System.out.println("2. Remove Employee");
            System.out.println("3. Update Employee");
            System.out.println("4. Display Employees");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\nSelect Employee Type:");
                    System.out.println("1. Full-Time Employee");
                    System.out.println("2. Part-Time Employee");
                    System.out.print("Enter your choice: ");
                    int empType = scanner.nextInt();

                    System.out.print("Enter Employee Name: ");
                    scanner.nextLine();
                    String name = scanner.nextLine();

                    System.out.print("Enter Employee ID: ");
                    int id = scanner.nextInt();

                    if (empType == 1) {
                        System.out.print("Enter Monthly Salary: ");
                        double salary = scanner.nextDouble();
                        FullTimeEmployee fullTimeEmployee = new FullTimeEmployee(name, id, salary);
                        payrollSystem.addEmployee(fullTimeEmployee);
                    } else if (empType == 2) {
                        System.out.print("Enter Hours Worked: ");
                        int hoursWorked = scanner.nextInt();
                        System.out.print("Enter Hourly Rate: ");
                        double hourlyRate = scanner.nextDouble();
                        PartTimeEmployee partTimeEmployee = new PartTimeEmployee(name, id, hoursWorked, hourlyRate);
                        payrollSystem.addEmployee(partTimeEmployee);
                    } else {
                        System.out.println("Invalid Employee Type.");
                    }
                    break;

                case 2:
                    System.out.print("Enter Employee ID to Remove: ");
                    int removeId = scanner.nextInt();
                    payrollSystem.removeEmployee(removeId);
                    break;

                case 3:
                    System.out.println("\nSelect Employee Type to Update:");
                    System.out.println("1. Full-Time Employee");
                    System.out.println("2. Part-Time Employee");
                    System.out.print("Enter your choice: ");
                    int updateType = scanner.nextInt();

                    System.out.print("Enter Employee ID to Update: ");
                    int updateId = scanner.nextInt();

                    System.out.print("Enter Updated Employee Name: ");
                    scanner.nextLine();  // Consume newline
                    String updatedName = scanner.nextLine();

                    if (updateType == 1) {
                        System.out.print("Enter Updated Monthly Salary: ");
                        double updatedSalary = scanner.nextDouble();
                        payrollSystem.updateEmployee(updateId, updatedName, updatedSalary, 0, 0, true);
                    } else if (updateType == 2) {
                        System.out.print("Enter Updated Hours Worked: ");
                        int updatedHoursWorked = scanner.nextInt();
                        System.out.print("Enter Updated Hourly Rate: ");
                        double updatedHourlyRate = scanner.nextDouble();
                        payrollSystem.updateEmployee(updateId, updatedName, 0, updatedHoursWorked, updatedHourlyRate, false);
                    } else {
                        System.out.println("Invalid Employee Type.");
                    }
                    break;

                case 4:
                    payrollSystem.displayEmployees();
                    break;

                case 5:
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }
}