package cf.spring.data.ex3;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

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
}
