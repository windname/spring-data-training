package cf.spring.data.ex2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DataApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(DataApplication.class, args);
        BookService service = (BookService)ctx.getBean("bookService");
        service.buyBook(1);
		service.getBook(1);

		service.addBookAndList();
	}
}
