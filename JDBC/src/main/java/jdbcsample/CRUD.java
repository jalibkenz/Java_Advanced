package jdbcsample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CRUD {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		// New Connection to write into table.
		Connection c3 = DriverManager.getConnection("jdbc:mysql://localhost:3306/JSpiders", "root", "R_ke5nz7");
		Statement s3 = c3.createStatement();
		String enterEmployee1 = "INSERT INTO employees VALUES (201," + "'Jalib Kenz'," + "9995550088)";
		String enterEmployee2 = "INSERT INTO employees VALUES (301," + "'Nihal Khaiez'," + "8330048899)";
		String enterEmployee3 = "INSERT INTO employees VALUES (401," + "'Lail Kinan'," + "9633663305)";
		s3.execute(enterEmployee1);
		s3.execute(enterEmployee2);
		s3.execute(enterEmployee3);
		System.out.println("3 Employee Details saved to Table");
		

		// update
		s3.execute("UPDATE employees SET nameEmployee='Priya', phoneEmployee=1234567890 where idEmployee=201");
		System.out.println("201-Jalib changed to Priya");

		// Fetch all records
		ResultSet rs = s3.executeQuery("SELECT * FROM EMPLOYEES WHERE idEmployee in (%01)");
		while (rs.next()) {
			System.out.println("Employee ID: " + rs.getInt(1) + "|Employee Name: " + rs.getString(2)
					+ "|Employee Phone: " + rs.getLong(3));
		}
		c3.close();
	}

}
