package com.example.ems;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;

public class EmployeeImplement implements EmployeeInterface{

    Connection connection;

//1
    @Override
    public void createEmployee(Employee employee ){
        connection = DatabaseConnection.createDatabaseConnection();
        String query = "INSERT INTO employee VALUES(?,?,?,?)";
        try{    
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, employee.getId());
            preparedStatement.setString(2, employee.getName());
            preparedStatement.setDouble(3, employee.getSalary());
            preparedStatement.setInt(4, employee.getAge());
            int count = preparedStatement.executeUpdate();
            if(count != 0){
                System.out.println("Employee insreted successfully\n");
            }else{
                System.out.println("ID already taken");
            }
    }catch(Exception ex){
            ex.printStackTrace();
        }
    }
//2
    @Override
    public void showAllEmployee(){
        connection = DatabaseConnection.createDatabaseConnection();
        try{
            String query = "SELECT * FROM employee";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            System.out.format("%s\t%s\t%s\t%s\n","ID", "Name", "Salary", "Age");
            System.out.println("----------------------------");
            while(resultSet.next()){
                System.out.format("%d\t%s\t%s\t%d\n",
                resultSet.getInt(1),
                resultSet.getString(2),
                resultSet.getDouble(3),
                resultSet.getInt(4));
                System.out.println("----------------------------");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
//3
    @Override
    public void showEmployeeBasedOnId(int id){
        connection = DatabaseConnection.createDatabaseConnection();
        try{
            String query = "SELECT * FROM employee WHERE id="+id;
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            System.out.format("%s\t%s\t%s\t%s\n","ID", "Name", "Salary", "Age");
            System.out.println("----------------------------");
                while(resultSet.next()){
                    System.out.format("%d\t%s\t%s\t%d\n",
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getDouble(3),
                    resultSet.getInt(4));
                    System.out.println("----------------------------");
                }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
//4
    @Override
    public void updateEmployee(int id, String name){
        connection = DatabaseConnection.createDatabaseConnection();
        try{
            String query = "UPDATE employee SET name =? WHERE id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(2, id);
            preparedStatement.setString(1, name);
            int count = preparedStatement.executeUpdate();
            if(count != 0){
                System.out.println("Employee updated successfully\n");
            }else{
                System.out.println("ID don't exist in database\n");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
//5
    @Override
    public void deleteEmployee(int id){
        connection = DatabaseConnection.createDatabaseConnection();
        try{
            String query = "DELETE FROM employee WHERE id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            int count = preparedStatement.executeUpdate();
            if(count != 0){
                System.out.println("Employee deleted successfully\n");
            }else{
                System.out.println("ID don't exist in database\n");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
