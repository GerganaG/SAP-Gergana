import java.util.ArrayList;

public interface IUserManager {

	User readUser(String username);

	void registerUser(User user) throws Exception;

	void deleteUser(String name);

	void updateUser(String name, User user);
	
	ArrayList<User> readUsers();
}
