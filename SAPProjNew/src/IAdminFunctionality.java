import java.util.ArrayList;

public interface IAdminFunctionality extends IBookManager{

	void registerUser(User user);
	ArrayList<User> showUsers();
	void changeUserInformation(User user);
	void removeUser(User user);
}
