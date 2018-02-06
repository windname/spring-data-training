package cf.spring.data.ex3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author vgrigoriev - 2/3/2018
 */
@Service
public class BookService {
    @Autowired
    BookDAO bookDAO;

    public void getBook(int bookId) {
        Book book = bookDAO.getBookById(bookId);
        System.out.println("User bought book: " + book);
    }

    public void addBook() {
        Book b = new Book();
        b.setName("Harry Potter");
        b.setAuthorId(2);
        bookDAO.addBook(b);
    }

    public void getBookbyAuthor(int bookId) {
        Book book = bookDAO.getBookByAuthor(bookId);
        System.out.println("User bought book: " + book);
    }

    public void deleteBookAndList(int id) {
        bookDAO.deleteBook(2);
        bookDAO.getBooks().forEach(System.out::println);

    }





}
