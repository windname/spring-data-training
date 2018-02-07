package cf.spring.data.ex2;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

/**
 * @author vgrigoriev - 2/3/2018
 */
@Repository
public class BookDAOImpl implements BookDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public String getBookNameById(int id) {
        return (String)jdbcTemplate.queryForObject("select name from book where id=?", String.class, id);
    }

    @Override
    public Book getBookById(int id) {
        return jdbcTemplate.queryForObject(
                "select * from book where id=?",
                new Object[]{id},
                new RowMapper<Book>() {
                    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Book book = new Book();
                        book.setId(rs.getInt("id"));
                        book.setName(rs.getString("name"));
                        return book;
                    }
                });
    }


    @Autowired private PlatformTransactionManager  platformTransactionManager;
    @Override
    public void addRowAndList() {
        TransactionStatus status = platformTransactionManager.getTransaction(new DefaultTransactionDefinition());
        try {
            jdbcTemplate.update("insert into book (name, author_id) values ('Harry Potter', 2)");

            List<Map<String, Object>> list = jdbcTemplate.queryForList("select name from book");
            for (Map<String, Object> row : list) {
                System.out.println(row.get("name"));
            }
            platformTransactionManager.commit(status);
        } catch (Exception ex) {
            platformTransactionManager.rollback(status);
            ex.printStackTrace();
        }
    }


}
