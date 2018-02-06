package cf.spring.data.ex11;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DataApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(DataApplication.class, args);
		BookRepository service = (BookRepository)ctx.getBean("bookRepository");
		service.findAll().forEach(b -> System.out.println("Book:" + b.getName()));
	}
}
