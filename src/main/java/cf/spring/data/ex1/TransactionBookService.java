package cf.spring.data.ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author vgrigoriev - 2/6/2018
 */
public class TransactionBookService {
    public void getBook() {
        try(Connection conn = getConnection()) {
            createAndListBook(conn);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private Connection getConnection() throws Exception {

        Object obj = Class.forName("com.mysql.jdbc.Driver").newInstance();

        Connection conn = null;
        Properties connectionProps = new Properties();
        connectionProps.put("user", "root");

        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop",
                connectionProps);
        return conn;
    }

    private void createAndListBook(Connection conn) throws SQLException {
        Statement st = null;
        Statement st2 = null;
        ResultSet rs = null;
        try {
            if (conn.getMetaData().supportsTransactionIsolationLevel(Connection.TRANSACTION_READ_COMMITTED)) {
                conn.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
            }

            conn.setAutoCommit(false);

            st2 = conn.createStatement();
            st2.executeUpdate("insert into book (name, author_id) values ('Harry Potter', 2)");
            st = conn.createStatement();
            rs = st.executeQuery("select name from book");

            while (rs.next()) {
                String name = rs.getString(1);
                System.out.println("Book:" + name);
            }

            conn.commit();

        } catch (Exception e) {
            conn.rollback();
            e.printStackTrace();
        } finally {
            if (st2 != null) {
                try {
                    st2.close();
                } catch (Exception ex){}
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception ex){}
            }
            if (st != null) {
                try {
                    st.close();
                } catch (Exception ex){}
            }
            conn.setAutoCommit(true);
        }
    }

}
