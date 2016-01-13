import java.sql.SQLException;
import java.util.Calendar;
import java.sql.*;

public class LoanManager implements ILoanManager{
	private PreparedStatement prStatement = null;
	private int bookId;
	private int userId;
	Calendar calendar = Calendar.getInstance();
	java.sql.Date ourJavaDateObject = new java.sql.Date(calendar.getTime().getTime());
	
	@Override
	public void loanBook(String username, String title) throws SQLException {
		String query = "INSERT into loans(user_id, book_id, loan_date) " + "values (?, ?, ?)";
		
		try {
			prStatement = MySQLAccess.getConnection().prepareStatement(query);

			prStatement.setInt(1, userId);
			prStatement.setInt(2, bookId);
			prStatement.setDate(3, ourJavaDateObject);			

			prStatement.executeUpdate();

		} catch (Exception e1) {
			e1.printStackTrace();
	}
	}
	public void getBookID(int id){
		this.bookId = id;
	}
	public void getUserID(int id){
		this.userId = id; 
	}

}
