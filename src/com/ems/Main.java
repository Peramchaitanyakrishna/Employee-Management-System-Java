package com.ems;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EmployeeDaoIntrf dao = new EmployeeDaoImpl();
        System.out.println("Welcome to Employee Management System");
        
        Scanner sc = new Scanner(System.in);
        
        do {
            System.out.println("\n1. Add Employee\n" +
                    "2. Show All Employees\n" +
                    "3. Show Employee Based on id\n" +
                    "4. Update Employee\n" +
                    "5. Delete Employee\n" +
                    "6. Exit");

            System.out.print("Enter Choice: ");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    Employee emp = new Employee();
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    System.out.print("Enter Name: ");
                    String name = sc.next();
                    System.out.print("Enter Email: ");
                    String email = sc.next();
                    System.out.print("Enter Salary: ");
                    double salary = sc.nextDouble();
                    
                    emp.setId(id);
                    emp.setName(name);
                    emp.setEmail(email);
                    emp.setSalary(salary);
                    
                    dao.createEmployee(emp);
                    break;
                case 2:
                    dao.showAllEmployee();
                    break;
                case 3:
                    System.out.print("Enter ID to show details: ");
                    int empid = sc.nextInt();
                    dao.showEmployeeBasedOnID(empid);
                    break;
                case 4:
                    System.out.print("Enter ID to update: ");
                    int empid1 = sc.nextInt();
                    System.out.print("Enter new Name: ");
                    String name1 = sc.next();
                    dao.updateEmployee(empid1, name1);
                    break;
                case 5:
                    System.out.print("Enter ID to delete: ");
                    int id2 = sc.nextInt();
                    dao.deleteEmployee(id2);
                    break;
                case 6:
                    System.out.println("Thank you for using our Application!");
                    System.exit(0);
                default:
                    System.out.println("Enter valid choice!");
                    break;
            }
        } while (true);
    }
}