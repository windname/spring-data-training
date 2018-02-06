package cf.spring.data.ex2;

/**
 * @author vgrigoriev - 2/1/2018
 * domain object
 */
public class Book {

    private int id;

    private String name;

    private int authorId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    @Override
    public String toString() {
        return "Book{" + "id=" + id + ", name='" + name + '\'' + ", authorId=" + authorId + '}';
    }
}
