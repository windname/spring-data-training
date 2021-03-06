package cf.spring.data.ex3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;

/**
 * JPA
 */
@SpringBootApplication
public class DataApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(DataApplication.class, args);
		BookService service = (BookService)ctx.getBean("bookService");
		service.getBook(1);
		service.addBook();
		service.getBookbyAuthor(2);
		service.deleteBookAndList(2);

	}

	@Bean
	public HibernateJpaSessionFactoryBean sessionFactory() {
		return new HibernateJpaSessionFactoryBean();
	}
}
