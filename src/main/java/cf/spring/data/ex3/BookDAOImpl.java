package cf.spring.data.ex3;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author vgrigoriev - 2/4/2018
 */
@Repository
@Transactional
public class BookDAOImpl implements BookDAO {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Book getBookById(int id) {
        return (Book)sessionFactory.getCurrentSession().get(Book.class, id);
    }

    @Override
    public Book getBookByAuthor(int id) {
        return (Book)sessionFactory.getCurrentSession().createQuery("from Book where author_id=:id")
                .setParameter("id",id).list().get(0);
    }

    @Override
    public void addBook(Book b) {
        sessionFactory.getCurrentSession().saveOrUpdate(b);
    }

    @Override
    public void deleteBook(int id) {
        Session session = sessionFactory.getCurrentSession();
        Book book = session.byId(Book.class).load(id);
        session.delete(book);
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED, timeout = 5, rollbackFor = NullPointerException.class)
    public List<Book> getBooks() {
        Session session = sessionFactory.getCurrentSession();
        return  session.createCriteria(Book.class).list();
    }

}
