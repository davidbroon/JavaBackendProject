package com.david;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Aa1Application {

	 public static void main(String[] args) {
	        SpringApplication.run(Aa1Application.class, args);

	                Connection con;
	                try {	               
	                    con = DriverManager.getConnection("jdbc:sqlite:./users.sqlite", "", "");

	                    Statement stmt = con.createStatement();

	                    ResultSet rs = stmt.executeQuery("SELECT * FROM User");

	                    int id;
	                    String firstName;
	                    String lastName;

	                    while (rs.next()) {

	                        id= rs.getInt("ID");
	                        firstName = rs.getString("firstName");
	                        lastName = rs.getString("lastName");

	                        System.out.println("ID: '" + id + "', First Name: '" + firstName + "', Last Name: '" + lastName + "'.");
	                    }
	                } catch (SQLException e) {
	                    e.printStackTrace();
	                }
	    }
	      
	    }
	