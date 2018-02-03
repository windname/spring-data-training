package cf.spring.data.ex2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DataApplication {

	public static void main(String[] args) throws SQLException {
		DataApplication data = new DataApplication();
		try(Connection conn = data.getConnection()) {
			data.printBookName(conn);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void printBookName(Connection conn) throws SQLException {
		Statement st = null;
		ResultSet rs = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery("select name from book");
			while (rs.next()) {
				String name = rs.getString(1);
				System.out.println("Book:" + name);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (st != null) {
				st.close();
			}
		}
	}

	public Connection getConnection() throws Exception {

		Object obj = Class.forName("com.mysql.jdbc.Driver").newInstance();

		Connection conn = null;
		Properties connectionProps = new Properties();
		connectionProps.put("user", "root");

		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop",
					connectionProps);
		return conn;
	}


}
