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
public class BookDAOImpl implements BookDAO {
    @PersistenceContext
    private EntityManager entityManager;

    public Book getBookById(int id) {
//        return (Book)entityManager.createQuery("from Book as b where b.id=:id").setParameter("id", id)
//                .getResultList().get(0);
        return (Book)entityManager.createQuery("from Book as b where b.id=?1").setParameter(1, id)
                .getResultList().get(0);
    }
}
