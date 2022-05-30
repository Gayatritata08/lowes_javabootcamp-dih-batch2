package com.labs.jdbc;

 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

 

public class JdbcDemo {
    
    public static void main(String[] args) {
        System.out.println("JDBC Demo...");
        
        Connection con = null;
        Statement stmt = null;
        ResultSet  rs = null;
        
        //STEP 1: Load Driver (MySQL)
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded");
        } catch (ClassNotFoundException e) {
            System.out.println("Error: Drive not loaded - " + e.getMessage());
            e.printStackTrace();
            return;
        }
        
        //STEP 2: Open Connection to DB
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbctraining", "training", "training");
            System.out.println(con);
            System.out.println("Connected to DB successfully");
            
            //STEP 3: Create Statement
            stmt = con.createStatement();
            
            String query = "SELECT * FROM EMPLOYEE";
            
            //STEP 4: Execute Query
            rs = stmt.executeQuery(query);
            System.out.println("Query executed successfully. Query: " + query);
            
            //STEP 5: Get ResultSet and access the results
            System.out.println("Got results - " + rs);
            System.out.println("EmpID \t Name \t Age \t Designation \t Department \t Country");
            while(rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String designation = rs.getString("designation");
                String department = rs.getString("department");
                String country = rs.getString("country");
                System.out.printf("%d \t %s \t %d \t %s \t %s \t %s \n", id, name, age, designation, department, country);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                stmt.close();
                con.close();                
            } catch (SQLException e) {
                System.out.println("Error while closing the connections. " + e.getMessage());
                e.printStackTrace();
            } 
        }        
        
    }

 

}