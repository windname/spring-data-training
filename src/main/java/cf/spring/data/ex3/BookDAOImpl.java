package cf.spring.data.ex3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
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
}
