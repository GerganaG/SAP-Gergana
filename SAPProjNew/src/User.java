import java.io.Serializable;
import java.util.ArrayList;

public class User implements IUserManager, IAdminFunctionality, IEmployeeFuctionality, Serializable{
	
//	private final static String REGEX = "[a-z0-9]";
	public static final long serialVersionUID = 1l;
	
	private String username;
	private String password;
	private String role;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String username, String password, String role) throws Exception{
		setUsername(username);
		setPassword(password);
		setRole(role);
	}

	public void setUsername(String username) throws InvalidCreditentialsException {
//		if(username.matches(REGEX)){
			this.username = username;
	//	} else{
		//	throw new InvalidCreditentialsException("Invalid username!!!");
		//}
		
	}

	public void setPassword(String password) throws Exception {
//		if(password.matches(REGEX)){
			this.password = AESencrp.encrypt(password);
//		}
//		else throw new InvalidCreditentialsException("Wrong password!!!");
	}

	public void setRole(String role) throws InvalidCreditentialsException {
//		if(role.equals(Role.ADMINISTRATOR) || role.equals(Role.EMPLOYEE) || role.equals(Role.CUSTOMER)){
			this.role = role;
//		} else{
//			throw new InvalidCreditentialsException("Invalid role!!!");
//		}
	}
	
	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getRole() {
		return role;
	}

	@Override
	public boolean loginUser(String name, String password){
		// TODO Auto-generated method stub
		ArrayList<User> list = TestMain.readFileUsers();
		
		boolean flag = false;		
		for (User user : list) {
			if(user.getUsername().equals(name) && user.getPassword().equals(password)){
				flag = true;
				try {
					this.setUsername(user.getUsername());
					this.setPassword(user.getPassword());
					this.setRole(user.getRole());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			
			}
		}
		return flag;
	}

	@Override
	public boolean isUserInRole(String name) {
		// TODO Auto-generated method stub
		if(this.role.equalsIgnoreCase(name)){
			return true;
		} else{
			return false;
		}
	}
	
	public String toString(){
		return username + "***" + password + "***" + role;
	}

	@Override
	public void addBook(Book book) {
		TestMain.writeToFile(TestMain.PATH_BOOKS, book);
	}

	@Override
	public void showBooks() {
		// TODO Auto-generated method stub
		ArrayList<Book> list = TestMain.readFileBooks();
		for (Book book : list) {
			System.out.println(book);
		}
	}

	@Override
	public void updateBook(Book book) {
		// TODO Auto-generated method stub
		ArrayList<Book> books = TestMain.readFileBooks();
		for (int i = 0; i < books.size(); i++) {
			if(book.equals(books.get(i))){
				this.removeBook(book);				
				String[] array = TestMain.BookInformation();				
				this.addBook(new Book(array[0], array[1], array[2], Integer.parseInt(array[3]), array[4]));					
				break;
			} else{
				System.out.println("There is`n that book!!!");
			}
		}
	}

	@Override
	public void removeBook(Book book) {
		// TODO Auto-generated method stub
		ArrayList<Book> books = TestMain.readFileBooks();
		for (int i = 0; i < books.size(); i++) {
			if(book.equals(books.get(i))){
				books.remove(i);
			}
		}
			
		TestMain.rewriteBooks(books);
		for(int i = 0; i < books.size(); i++){
			TestMain.writeToFile(TestMain.PATH_BOOKS, books.get(i));
		}		
	}

	@Override
	public void registerCustomer(User customer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<User> showCustomers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void changeCustomerInformation(User customer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeCustomer(User customer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean searchBook(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean searchCustomer(String username) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void registerUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<User> showUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void changeUserInformation(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeUser(User user) {
		// TODO Auto-generated method stub
		
	}
	
}
