
import java.sql.SQLException;
import java.util.ArrayList;

public class Login implements ILogin, IRoleChecker {

	@Override	
	public String isUserInRole(String username) throws InvalidCreditentialsException, SQLException {
		UserManager um = new UserManager();
		User u = um.readUser(username);
		return u.getRole();
	}

	@Override
	public boolean loginUser(String name, String password) throws Exception {
		UserManager um = new UserManager();
		ArrayList<User> list = um.readUsers();
		for (User u : list) {
			if (u.getUsername().equals(name)) {
				return true;
			} 
		}
		return false;
	}

}
