import java.sql.SQLException;

public interface ILoanManager {
	void loanBook(String username, String title) throws SQLException;
	void getBookID(int id);
	void getUserID(int id);
}
