package com.example.ems;

import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EmployeeInterface employeeInterface = new EmployeeImplement();
        System.out.println(
        "Welcome to data base employee managment application\n"+
        "Enter number to choose action:\n"
        );
        do{
            System.out.println(
            "1. Add employee\n"+
            "2. Show all employees\n"+
            "3. Show employee based on ID\n"+
            "4. Update employee\n"+
            "5. Delete employee\n"
            );
            int choice = scanner.nextInt();
            System.out.println();
            switch(choice){
                case 1:    
                    System.out.print("Enter ID: ");
                    int ID_1 = scanner.nextInt();
                    System.out.print("Enter name: ");
                    String name_1 = scanner.next();
                    System.out.print("Enter salary: ");
                    double salary = scanner.nextDouble();
                    System.out.print("Enter age: ");
                    int age = scanner.nextInt();
                    System.out.println();
                    Employee employee = new Employee();
                    employee.setId(ID_1);
                    employee.setName(name_1);
                    employee.setSalary(salary);
                    employee.setAge(age);
                    employeeInterface.createEmployee(employee);
                    break;
                case 2:
                    employeeInterface.showAllEmployee();
                    break;
                case 3:
                    System.out.print("Enter ID to show details: ");
                    int ID_3 = scanner.nextInt();
                    System.out.println();
                    employeeInterface.showEmployeeBasedOnId(ID_3);
                    break;
                case 4:
                    System.out.print("Enter ID to update details: ");
                    int ID_4 = scanner.nextInt();
                    System.out.print("Enter new name: ");
                    String name_4 = scanner.next();
                    System.out.println();
                    employeeInterface.updateEmployee(ID_4, name_4);
                    break;
                case 5:
                    System.out.print("Enter ID to delete employee: ");
                    int ID_5 = scanner.nextInt();
                    System.out.println();
                    employeeInterface.deleteEmployee(ID_5);
                    break;
            }
        }while(true);
    }
}
