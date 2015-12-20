
public interface IUserManager {
	
	boolean loginUser(String name, String password);
	boolean isUserInRole(String username);
	
}
