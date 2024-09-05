// program to find employee id, name,salary ,tax
import java.util.Scanner;
public interface Taxable {

    // Taxable Interface
        double SALES_TAX = 0.07;     // 7% sales tax
        double INCOME_TAX = 0.105;   // 10.5% income tax

        // Abstract method to calculate tax
        double calcTax();
    }

    // Employee class implementing Taxable to calculate income tax
    class Employee implements Taxable {
        private int empId;
        private String name;
        private double salary;

        // Constructor to initialize Employee attributes
        public Employee(int empId, String name, double salary) {
            this.empId = empId;
            this.name = name;
            this.salary = salary;
        }

        // Implementing calcTax method to calculate income tax on yearly salary
        @Override
        public double calcTax() {
            return salary * INCOME_TAX;  // Calculating income tax based on salary
        }

        // Method to display employee details and tax
        public void displayEmployeeDetails() {
            System.out.println("Employee ID: " + empId);
            System.out.println("Employee Name: " + name);
            System.out.println("Yearly Salary: $" + salary);
            System.out.println("Income Tax: $" + calcTax());
        }
    }

    // Product class implementing Taxable to calculate sales tax
    class Product implements Taxable {
        private int pid;
        private double price;
        private int quantity;

        // Constructor to initialize Product attributes
        public Product(int pid, double price, int quantity) {
            this.pid = pid;
            this.price = price;
            this.quantity = quantity;
        }

        // Implementing calcTax method to calculate sales tax on unit price
        @Override
        public double calcTax() {
            return price * SALES_TAX;  // Calculating sales tax based on unit price
        }

        // Method to display product details and tax
        public void displayProductDetails() {
            System.out.println("Product ID: " + pid);
            System.out.println("Price per Unit: $" + price);
            System.out.println("Quantity: " + quantity);
            System.out.println("Sales Tax per Unit: $" + calcTax());
        }
    }

    // Main class to interact with the user and display tax information
    class DriverMain {
        public static void main(String[] args) {
            Scanner obj = new Scanner(System.in);

            // Input for Employee
            System.out.println("Enter Employee Details:");
            System.out.print("Employee ID: ");
            int empId = obj.nextInt();
            obj.nextLine();  // Consume newline
            System.out.print("Employee Name: ");
            String empName = obj.nextLine();
            System.out.print("Employee Salary: ");
            double empSalary = obj.nextDouble();

            // Create Employee object and display income tax details
            Employee employee = new Employee(empId, empName, empSalary);
            employee.displayEmployeeDetails();

            // Input for Product
            System.out.println("\nEnter Product Details:");
            System.out.print("Product ID: ");
            int pid = obj.nextInt();
            System.out.print("Price per Unit: ");
            double price = obj.nextDouble();
            System.out.print("Quantity: ");
            int quantity = obj.nextInt();

            // Create Product object and display sales tax details
            Product product = new Product(pid, price, quantity);
            product.displayProductDetails();
        }
    }

