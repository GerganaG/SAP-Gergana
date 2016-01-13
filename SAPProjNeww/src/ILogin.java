import java.sql.SQLException;

public interface ILogin {
	boolean loginUser(String name, String password) throws Exception;
}
