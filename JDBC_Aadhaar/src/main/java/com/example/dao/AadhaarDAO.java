package com.example.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.Statement;

public class AadhaarDAO {

	
public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		//Connection to create DB
		Connection c1 = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "R_ke5nz7");
		Statement s1 = c1.createStatement();
		s1.execute("CREATE DATABASE AadhaarDB");
		System.out.println("-> DataBase - Created");
		c1.close();
		
		
		// Connection to create table inside the database
		Connection c2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/AadhaarDB", "root", "R_ke5nz7");
		Statement s2 = c2.createStatement();
		s2.execute("CREATE TABLE AADHAARS (aadhaarName VARCHAR(50) NOT NULL, aadhaarNumber BIGINT(15) NOT NULL UNIQUE)");
		System.out.println("-> Table - Created");
		c2.close();
		
		
		//C in CRUD
		//Connection to insert Aadhaar numbers
		Connection c3 = DriverManager.getConnection("jdbc:mysql://localhost:3306/AadhaarDB", "root", "R_ke5nz7");
		Statement s3 = c3.createStatement();
		s3.execute("INSERT INTO AADHAARS (aadhaarName, aadhaarNumber) VALUES ('Jalib', 770082693698)");
		s3.execute("INSERT INTO AADHAARS (aadhaarName, aadhaarNumber) VALUES ('Nihal', 990082693999)");
		s3.execute("INSERT INTO AADHAARS (aadhaarName, aadhaarNumber) VALUES ('Lail', 880082693888)");
		System.out.println("-> CREATE in CRUD Performed");
		c3.close();
		
		//R in CRUD
		//Connection to read Aadhaar numbers
		Connection c4 = DriverManager.getConnection("jdbc:mysql://localhost:3306/AadhaarDB", "root", "R_ke5nz7");
		Statement s4 = c4.createStatement();
		ResultSet rs = s4.executeQuery("SELECT aadhaarName, aadhaarNumber FROM AADHAARS");
		while (rs.next()) {
			System.out.println("Aadhaar Name: " + rs.getString(1) + " | Aadhaar ID: " + rs.getLong(2));
		}
		System.out.println("-> READ in CRUD Performed");
		c4.close();
		
		
		//U in CRUD
		//Connection to update Aadhaar numbers
		Connection c5 = DriverManager.getConnection("jdbc:mysql://localhost:3306/AadhaarDB", "root", "R_ke5nz7");
		Statement s5 = c5.createStatement();
		s5.execute("UPDATE AADHAARS SET aadhaarName = 'Jalib Kenz' WHERE aadhaarNumber = 770082693698");
		System.out.println("-> UPDATE in CRUD Performed");
		c5.close();
		
		
		//D in CRUD
		//Connection to delete Aadhaar numbers
		Connection c6 = DriverManager.getConnection("jdbc:mysql://localhost:3306/AadhaarDB", "root", "R_ke5nz7");
		Statement s6 = c6.createStatement();
		s6.execute("DELETE FROM AADHAARS WHERE aadhaarNumber = 880082693888");
		System.out.println("-> DELETE in CRUD Performed");
		c6.close();

	}
}
