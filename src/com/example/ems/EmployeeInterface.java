package com.example.ems;

public interface EmployeeInterface {

    //create employee
    public void createEmployee(Employee employee);
    //show all employee
    public void showAllEmployee();
    //show emplyee based on id
    public void showEmployeeBasedOnId(int id);
    //update employee
    public void updateEmployee(int id, String name);
    //delete employee
    public void deleteEmployee(int id);

}
