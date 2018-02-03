package cf.spring.data.ex3;

import cf.spring.data.ex1.BookRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DataApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(DataApplication.class, args);
        BookService service = (BookService)ctx.getBean("bookService");
        service.buyBook(1);
	}
}
