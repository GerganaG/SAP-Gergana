
import java.sql.SQLException;
import java.util.ArrayList;

public interface IBookManager {
	Book getBook(String title) throws SQLException;

	void addBook(Book book);

	void updateBook(String title, Book book);

	void deleteBook(String title);

	ArrayList<Book> readBook();
}
