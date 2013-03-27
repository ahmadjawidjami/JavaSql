package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class sqlConnection2 {
	String userName = "root";
	String password = "jami";
	String url = "jdbc:mysql://localhost/temp";
	static Connection conn = null;

	public sqlConnection2() throws Exception {
		// Class.forName("com.mysql.jdbc.Driver").newInstance();
		conn = DriverManager.getConnection(url, userName, password);
		System.out.println("Database connection established successfully..");
	}

	public static void main(String[] args) throws Exception {
		sqlConnection2 sql = new sqlConnection2();
		PreparedStatement ps = conn
				.prepareStatement("insert into animal values (?,?,?)");
		ps.setString(1, "cat");
		ps.setInt(2, 2);
		ps.setString(3, "wild");

		Statement cs = conn.createStatement();
		cs.executeQuery("select * from animal");
		ResultSet rs = cs.getResultSet();
		while (rs.next()) {
			String name = rs.getString(1);
			int id = rs.getInt("id");
			String type = rs.getString("type");
			System.out.println(name + "\t" + id + "\t" + type);
		}
		cs.close();
		rs.close();
		// ps.execute();

	}

}
