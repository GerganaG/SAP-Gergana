
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookManager implements IBookManager {
	private PreparedStatement prStatement = null;

	@Override
	public void addBook(Book book) {
		String query = "INSERT into book(title, author, genre, pages, year, isbn) " + "values (?, ?, ?, ?, ?, ?)";
		try {
			prStatement = MySQLAccess.getConnection().prepareStatement(query);

			prStatement.setString(1, book.getTitle());
			prStatement.setString(2, book.getAuthor());
			prStatement.setString(3, book.getGenre());
			prStatement.setInt(4, book.getNumberOfPages());
			prStatement.setString(5, book.getYear());
			prStatement.setString(6, book.getIsbn());

			prStatement.executeUpdate();

		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public Book getBook(String title) throws SQLException{
//		ArrayList<Book> list = this.readBook();
//		Book tmpBook = null;
//		for (Book book : list) {
//			if (book.getTitle().equalsIgnoreCase(title)) {
//				tmpBook = book;
//				break;
//			}
//		}
//		return tmpBook;
		
		String query = "SELECT book_id, title, author, genre, pages, year, isbn FROM book where title= ?";
		Book book = new Book();
		int id = 0;

		try {
			prStatement = MySQLAccess.getConnection().prepareStatement(query);
			prStatement.setString(1, title);
			ResultSet rs = prStatement.executeQuery();

			while (rs.next()) {
				id = rs.getInt("book_id");
				book.setTitle(rs.getString("title"));
				book.setAuthor(rs.getString("author"));
				book.setGenre(rs.getString("genre"));
				book.setPages(rs.getInt("pages"));
				book.setYear(rs.getString("year"));
				book.setISBN(rs.getString("isbn"));				
			}
			 ILoanManager lm = new LoanManager();
			 lm.getBookID(id);

		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return book;
	}

	@Override
	public void updateBook(String title, Book book) {
		String query = "UPDATE book SET title= ?, author= ?, genre= ?, pages= ?," + "year= ?, isbn= ? where title= ?";

		try {
			prStatement = MySQLAccess.getConnection().prepareStatement(query);

			prStatement.setString(1, book.getTitle());
			prStatement.setString(2, book.getAuthor());
			prStatement.setString(3, book.getGenre());
			prStatement.setInt(4, book.getNumberOfPages());
			prStatement.setString(5, book.getYear());
			prStatement.setString(6, book.getIsbn());
			prStatement.setString(7, title);

			prStatement.executeUpdate();

		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@Override
	public void deleteBook(String title) {
		String query = "DELETE from book where title= ?";

		try {
			prStatement = MySQLAccess.getConnection().prepareStatement(query);
			prStatement.setString(1, title);
			prStatement.executeUpdate();

		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	@Override
	public ArrayList<Book> readBook() {
		ArrayList<Book> list = new ArrayList<>();
		ResultSet rs = MySQLAccess.getResultSet("SELECT * from book");
		LoanManager ln = new LoanManager();

		try {
			while (rs.next()) {
//				int id = rs.getInt("book_id");
//				ln.getBookID(id);
				String title = rs.getString("title");
				String author = rs.getString("author");
				String genre = rs.getString("genre");
				int pages = rs.getInt("pages");
				String year = rs.getString("year");
				String isbn = rs.getString("isbn");
				list.add(new Book(title, author, genre, pages, year, isbn));
			}
			
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

}
