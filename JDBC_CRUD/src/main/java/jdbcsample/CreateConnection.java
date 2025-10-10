package jdbcsample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateConnection {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		// Connection to create DataBase
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c1 = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "R_ke5nz7");
		Statement s1 = c1.createStatement();
		s1.execute("CREATE DATABASE JSpiders");
		System.out.println("Data Base is Created");
		c1.close();

		// New Connection to create table inside the database
		Connection c2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/JSpiders", "root", "R_ke5nz7");
		Statement s2 = c2.createStatement();
		s2.execute("CREATE TABLE EMPLOYEES(idEmployee INT PRIMARY KEY, nameEmployee VARCHAR(50) NOT NULL, phoneEmployee BIGINT(15) NOT NULL UNIQUE)");
		System.out.println("Table is Created");
		c2.close();

		// New Connection to write into table.
		Connection c3 = DriverManager.getConnection("jdbc:mysql://localhost:3306/JSpiders", "root", "R_ke5nz7");
		Statement s3 = c3.createStatement();
		String enterEmployee1 = "INSERT INTO employees VALUES (101," + "'Jalib Kenz'," + "9995550077)";
		s3.execute(enterEmployee1);
		System.out.println("Employee1 Details saved to Table as a RECORD");
		c3.close();
	}
}