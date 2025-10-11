package jdbcsample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DynamicQueryInput {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/bescom", "root", "R_ke5nz7");

		
		
		
		
		// C --> CRUD
		System.out.print("------------------------C --> CRUD\n");
		System.out.print("Enter Employee ID: ");
		int id = sc.nextInt();
		sc.nextLine();

		System.out.print("Enter Name: ");
		String name = sc.next();
		sc.nextLine();

		System.out.print("Enter Email: ");
		String email = sc.next();
		sc.nextLine();

		System.out.print("Enter Phone: ");
		long phone = sc.nextLong();
		sc.nextLine();

		PreparedStatement s1 = c1.prepareStatement("insert into employees values(?,?,?,?)");
		s1.setInt(1, id);
		s1.setString(2, name);
		s1.setString(3, email);
		s1.setLong(4, phone);
		s1.execute();

		
		
		
		
		
		
		
		//R --> CRUD
		System.out.print("------------------------R --> CRUD\n");
		System.out.print("Enter Employee ID: ");
		int id2 = sc.nextInt();
		sc.nextLine();

		
		PreparedStatement s2 = c1.prepareStatement("select * from employees where empId=?");
		s2.setInt(1, id2);
		
		ResultSet rs = s2.executeQuery();
		rs.next();
		System.out.println("Employee ID:"+rs.getInt(1)+"\nEmployee Name:"+rs.getString(2)+"\nEmployee Email:"+rs.getString(3)+"\nEmployee Mobile:"+rs.getString(4));
		
		
		
		
		
		
		

		// U --> CRUD
		System.out.print("------------------------U --> CRUD\n");
		System.out.print("Enter Employee ID: ");
		int id3 = sc.nextInt();
		sc.nextLine();

		System.out.print("Enter Name: ");
		String name3 = sc.next();
		sc.nextLine();

		System.out.print("Enter Email: ");
		String email3 = sc.next();
		sc.nextLine();

		System.out.print("Enter Phone: ");
		long phone3 = sc.nextLong();
		sc.nextLine();

		PreparedStatement s3 = c1.prepareStatement("UPDATE employees SET empName = ?, empEmail = ?, empMobile = ? WHERE empId = ?");
		s3.setString(1, name3);
		s3.setString(2, email3);
		s3.setLong(3, phone3);
		s3.setLong(4, id3);
		s3.executeUpdate();
		
		
		
		
		// D --> CRUD
		System.out.print("------------------------D --> CRUD\n");
		System.out.print("Enter Employee ID: ");
		int id4 = sc.nextInt();
		sc.nextLine();
		
		PreparedStatement s4 = c1.prepareStatement("DELETE from employees WHERE empId = ?");
		s4.setInt(1, id4);
		s4.execute();
		
		
		
		
		

		
		
		
		
		// Last Close connection
		c1.close();

	}

}
