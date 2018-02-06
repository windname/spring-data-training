package cf.spring.data.ex1;


public class DataApplication {

	public static void main(String[] args) {
//		BookService bs = new BookService();
//		bs.getBook();

		TransactionBookService tbs = new TransactionBookService();
		tbs.getBook();

	}




}
