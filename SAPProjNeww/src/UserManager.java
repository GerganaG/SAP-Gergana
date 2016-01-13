import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserManager implements IUserManager {
	private PreparedStatement prStatement = null;

	@Override
	public User readUser(String username) {
		String query = "SELECT user_id, username, user_pass, role FROM user where username= ?";
		User user = new User();
		int id = 0;

		try {
			prStatement = MySQLAccess.getConnection().prepareStatement(query);
			prStatement.setString(1, username);
			ResultSet rs = prStatement.executeQuery();

			while (rs.next()) {
				id = rs.getInt("user_id");
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("user_pass"));
				user.setRole(rs.getString("role"));
			}
			
			ILoanManager lm = new LoanManager();
			lm.getUserID(id);

		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return user;
	}

	@Override
	public void registerUser(User user) throws Exception {
		String query = "INSERT into user(username, user_pass, role) " + "values (?, ?, ?)";
		try {
			prStatement = MySQLAccess.getConnection().prepareStatement(query);

			prStatement.setString(1, user.getUsername());
			prStatement.setString(2, user.getPassword());
			prStatement.setString(3, user.getRole());

			prStatement.executeUpdate();

		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	@Override
	public void deleteUser(String name) {
		String query = "DELETE from user where username = ?";

		try {
			prStatement = MySQLAccess.getConnection().prepareStatement(query);
			prStatement.setString(1, name);
			prStatement.executeUpdate();

		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}

	@Override
	public void updateUser(String name, User user) {
		String query = "UPDATE user SET username= ?, user_pass= ?, role= ? where username= ?";

		try {
			prStatement = MySQLAccess.getConnection().prepareStatement(query);

			prStatement.setString(1, user.getUsername());
			prStatement.setString(2, user.getPassword());
			prStatement.setString(3, user.getRole());
			prStatement.setString(4, name);

			prStatement.executeUpdate();

		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}

	@Override
	public ArrayList<User> readUsers() {
		ArrayList<User> list = new ArrayList<>();
		ResultSet rs = MySQLAccess.getResultSet("SELECT * from user");

		try {
			while (rs.next()) {
				String uName = rs.getString("username");
				String uPass = rs.getString("user_pass");
				String uRole = rs.getString("role");
				list.add(new User(uName, uPass, uRole));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}


}
