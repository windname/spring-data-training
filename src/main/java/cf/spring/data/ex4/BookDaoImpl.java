package cf.spring.data.ex4;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author vgrigoriev - 2/4/2018
 */
@Repository
public class BookDaoImpl {
    @PersistenceContext
    private EntityManager entityManager;

    public Book getBook() {
        return (Book)entityManager.createQuery("from Book")
                .getResultList().get(0);
    }
}
