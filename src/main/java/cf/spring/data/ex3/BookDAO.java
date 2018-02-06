package cf.spring.data.ex3;

import java.util.List;

/**
 * @author vgrigoriev - 2/1/2018
 */
public interface BookDAO {
    Book getBookById(int id);

    Book getBookByAuthor(int id);

    void addBook(Book b);

    void deleteBook(int id);

    List<Book> getBooks();
}
