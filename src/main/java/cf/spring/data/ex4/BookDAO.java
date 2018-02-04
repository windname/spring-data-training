package cf.spring.data.ex4;

import org.springframework.data.repository.CrudRepository;

/**
 * @author vgrigoriev - 2/1/2018
 */
public interface BookDAO {
    Book getBook();
}
