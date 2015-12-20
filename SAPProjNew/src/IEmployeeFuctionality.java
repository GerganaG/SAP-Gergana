import java.util.ArrayList;

public interface IEmployeeFuctionality {

	void registerCustomer(User customer);
	ArrayList<User> showCustomers();
	void changeCustomerInformation(User customer);
	void removeCustomer(User customer);
	boolean searchBook(String name);
	boolean searchCustomer(String username);
	
}
