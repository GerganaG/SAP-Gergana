import java.sql.SQLException;

public interface IRoleChecker {
	String isUserInRole(String username) throws InvalidCreditentialsException, SQLException;
}
