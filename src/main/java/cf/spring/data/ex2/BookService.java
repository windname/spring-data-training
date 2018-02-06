package cf.spring.data.ex2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author vgrigoriev - 2/3/2018
 */
@Service
public class BookService {
    @Autowired
    BookDAO bookDAO;

    public void buyBook(int bookId) {
        String book = bookDAO.getBookNameById(bookId);
        System.out.println("User bought book: " + book);
    }

    public void getBook(int bookId) {
        Book book = bookDAO.getBookById(bookId);
        System.out.println("User bought book: " + book);
    }
}
