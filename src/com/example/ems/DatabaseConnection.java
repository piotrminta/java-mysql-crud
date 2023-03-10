package com.example.ems;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

    static Connection connection;

    public static Connection createDatabaseConnection(){
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        //===============================================================
        //Insert database information:
        String url = "jdbc:mysql://localhost:3306/employeedatabase"+
        "?allowPublicKeyRetrieval=true&useSSL=false";
        String username = "root";
        String password = "piotr";
        //===============================================================
        connection = DriverManager.getConnection(url, username, password);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return connection;
    }
    
}
