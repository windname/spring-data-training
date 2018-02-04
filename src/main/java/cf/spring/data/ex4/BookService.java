package cf.spring.data.ex4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author vgrigoriev - 2/3/2018
 */
@Service
public class BookService {
    @Autowired
    BookDaoImpl bookDAO;

    public void getBook(int bookId) {
        Book book = bookDAO.getBook();
        System.out.println("User bought book: " + book);
    }
}
