package in.kenz.jdbc_user_input_cli.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class StudentController {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/JDBC_UserInputCLI_DB?createDatabaseIfNotExist=true", "root", "R_ke5nz7");
		Statement s = c.createStatement();
		s.execute("CREATE TABLE IF NOT EXISTS Student (id INT, name VARCHAR(20), mobileNumber BIGINT(10))");

		Scanner sc = new Scanner(System.in);

		// C
		String choice ="y";
		int idInput;
		String nameInput;
		Long mobileNumberInput;

		do{
			System.out.println("C in CRUD");
			System.out.println("Enter the Student Id");
			idInput = sc.nextInt();
			System.out.println("Enter the Student Name");
			nameInput = sc.next();
			System.out.println("Enter the Student Mobile Number");
			mobileNumberInput = sc.nextLong();
			String sql = "insert into Students values (?,?,?)";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, idInput);
			ps.setString(2, nameInput);
			ps.setLong(3, mobileNumberInput);
			System.out.println("Do you want to add more Student Details? To quit enter -> n");
			choice=sc.next();

		}while(choice !="n");

	}

}
