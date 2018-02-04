package cf.spring.data.ex3;

/**
 * @author vgrigoriev - 2/3/2018
 */
public interface BookDAO {
    String getBookNameById(int id);

    Book getBookById(int id);
}
