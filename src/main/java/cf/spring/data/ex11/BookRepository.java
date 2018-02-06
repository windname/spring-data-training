package cf.spring.data.ex11;

import org.springframework.data.repository.CrudRepository;

/**
 * @author vgrigoriev - 2/1/2018
 */
public interface BookRepository extends CrudRepository<Book, Long> {
}
