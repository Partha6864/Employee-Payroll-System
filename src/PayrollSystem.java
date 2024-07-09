import java.util.ArrayList;
import java.util.List;

class PayrollSystem {
    private List<Employee> employeeList;

    public PayrollSystem() {
        employeeList = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        boolean canAdd = true;
        for (Employee existingEmployee : employeeList) {
            if (existingEmployee.getId() == employee.getId() || existingEmployee.getName().equalsIgnoreCase(employee.getName())) {
                if (existingEmployee.getType().equals(employee.getType())) {
                    canAdd = false;
                    System.out.println("Employee with the same ID,name and type already exists.");
                    break;
                }
            }
        }
        if (canAdd) {
            employeeList.add(employee);
            System.out.println("Employee added successfully.");
        }
    }

    public void removeEmployee(int id) {
        Employee employeeToRemove = null;
        for (Employee employee : employeeList) {
            if (employee.getId() == id) {
                employeeToRemove = employee;
                break;
            }
        }
        if (employeeToRemove != null) {
            employeeList.remove(employeeToRemove);
            System.out.println("Employee removed successfully.");
        } else {
            System.out.println("Employee not found.");
        }
    }

    public void updateEmployee(int id, String name, double salary, int hoursWorked, double hourlyRate, boolean isFullTime) {
        for (Employee employee : employeeList) {
            if (employee.getId() == id) {
                if (isFullTime && employee instanceof FullTimeEmployee) {
                    ((FullTimeEmployee) employee).setMonthlySalary(salary);
                    employee.setName(name);
                    System.out.println("Full-Time Employee updated successfully.");
                    return;
                } else if (!isFullTime && employee instanceof PartTimeEmployee) {
                    ((PartTimeEmployee) employee).setHoursWorked(hoursWorked);
                    ((PartTimeEmployee) employee).setHourlyRate(hourlyRate);
                    employee.setName(name);
                    System.out.println("Part-Time Employee updated successfully.");
                    return;
                } else {
                    System.out.println("Employee type mismatch.");
                    return;
                }
            }
        }
        System.out.println("Employee not found.");
    }

    public void displayEmployees() {
        if (employeeList.isEmpty()) {
            System.out.println("No existing employee.");
        } else {
            for (Employee employee : employeeList) {
                System.out.println(employee);
            }
        }
    }
}