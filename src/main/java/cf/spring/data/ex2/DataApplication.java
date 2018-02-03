package cf.spring.data.ex2;

import cf.spring.data.ex1.BookRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DataApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(DataApplication.class, args);
		BookRepository service = (BookRepository)ctx.getBean("bookRepository");
	}
}
