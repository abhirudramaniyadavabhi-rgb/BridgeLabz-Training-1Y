import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface Department {
    void assignDepartment(String deptName);
    String getDepartmentDetails();
}

abstract class Employee implements Department {

    private int employeeId;
    private String name;
    private double baseSalary;
    private String department;

    public Employee(int employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void assignDepartment(String deptName) {
        this.department = deptName;
    }

    public String getDepartmentDetails() {
        return department;
    }

    public abstract double calculateSalary();

    public void displayDetails() {
        System.out.println("\nEmployee ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Department: " + department);
        System.out.println("Salary: " + calculateSalary());
        System.out.println("----------------------------");
    }
}

class FullTimeEmployee extends Employee {

    public FullTimeEmployee(int id, String name, double salary) {
        super(id, name, salary);
    }

    public double calculateSalary() {
        return getBaseSalary();
    }
}

class PartTimeEmployee extends Employee {

    private int workHours;
    private double hourlyRate;

    public PartTimeEmployee(int id, String name, double hourlyRate, int workHours) {
        super(id, name, 0);
        this.hourlyRate = hourlyRate;
        this.workHours = workHours;
    }

    public double calculateSalary() {
        return workHours * hourlyRate;
    }
}

public class EmployeeManagementSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Employee> employees = new ArrayList<>();

        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {

            System.out.println("\nEmployee " + (i + 1));
            System.out.print("Enter Employee ID: ");
            int id = sc.nextInt();

            sc.nextLine();
            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Department: ");
            String dept = sc.nextLine();

            System.out.print("Enter Type (1 = FullTime, 2 = PartTime): ");
            int type = sc.nextInt();

            Employee emp;

            if (type == 1) {
                System.out.print("Enter Base Salary: ");
                double salary = sc.nextDouble();
                emp = new FullTimeEmployee(id, name, salary);
            } else {
                System.out.print("Enter Hourly Rate: ");
                double rate = sc.nextDouble();
                System.out.print("Enter Work Hours: ");
                int hours = sc.nextInt();
                emp = new PartTimeEmployee(id, name, rate, hours);
            }

            emp.assignDepartment(dept);
            employees.add(emp);
        }

        System.out.println("\n===== Employee Details =====");

        for (Employee emp : employees) {
            emp.displayDetails();
        }

        sc.close();
    }
}
