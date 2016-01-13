
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Menu implements IMenuManager {

	public void menu() throws Exception {
		Scanner input = new Scanner(System.in, "UTF-8");
		System.out.println("Enter username: ");
		String username = input.nextLine();
		System.out.println("Enter password: ");
		String password = input.nextLine();

		Login lg = new Login();
		String role = null;
		if (lg.loginUser(username, AESencrp.encrypt(password))) {
			role = lg.isUserInRole(username);

		}
		switch (role) {
		case "administrator":
			adminMenu();
			break;
		case "employee":
			employeesMenu();
			break;
		}
	}

	public void adminMenu() throws Exception {
		Scanner input = new Scanner(System.in, "UTF-8");
		int choice;
		System.out.println("1. Books");
		System.out.println("2. Employees");
		System.out.println("3. Exit");
		System.out.println("Enter your choice: ");
		choice = input.nextInt();
//		input.nextLine();

		do {
			switch (choice) {
			case 1:
				adminBookMenu();
				break;
			case 2:
				adminEmployeeMenu();
				break;
			case 3:
				menu();
				break;
			default:
				System.out.println("Press a key 1 - 3");
			}

		} while (choice > 0 && choice <= 3);
	}

	public void adminBookMenu() throws Exception {
		Scanner input = new Scanner(System.in, "UTF-8");
		IBookManager bookManager = new BookManager();
		System.out.println("1. Create book");
		System.out.println("2. Read book");
		System.out.println("3. Update book");
		System.out.println("4. Delete book");
		System.out.println("5. Back");
		System.out.println("Enter your choice: ");
		int choice = input.nextInt();
		input.nextLine();

		do {
			switch (choice) {
			case 1: {
				String[] array = getBookInfo();
				bookManager.addBook(
						new Book(array[0], array[1], array[2], Integer.parseInt(array[3]), array[4], array[5]));
				System.out.println("Done");
				adminBookMenu();
				break;
			}
			case 2: {
				
				System.out.println("Enter title: ");
				String bookTitle = input.nextLine();
				System.out.println(bookManager.getBook(bookTitle));
				adminBookMenu();
				break;
			}
			case 3: {
				System.out.println("Enter the title of the book:");
				String bookTitle = input.nextLine();
				System.out.println("Enter new book: ");
				String[] array = getBookInfo();
				bookManager.updateBook(bookTitle,
						new Book(array[0], array[1], array[2], Integer.parseInt(array[3]), array[4], array[5]));
				System.out.println("Done!");
				adminBookMenu();
				break;
			}
			case 4: {
				System.out.println("Enter title: ");
				String bookTitle = input.nextLine();
				bookManager.deleteBook(bookTitle);
				System.out.println("Done!");
				adminBookMenu();
				break;
			}
			case 5:
				adminMenu();
				break;
			}
		} while (choice > 0 && choice <= 5);
	}

	@Override
	public void adminEmployeeMenu() throws Exception {
		Scanner input = new Scanner(System.in, "UTF-8");
		int choice;
		IUserManager userManager = new UserManager();
		System.out.println("1. Create employee");
		System.out.println("2. Read employee");
		System.out.println("3. Update employee");
		System.out.println("4. Delete employee");
		System.out.println("5. Back");
		System.out.println("Enter your choice: ");
		choice = input.nextInt();
		input.nextLine();

		do {
			switch (choice) {
			case 1: {
				System.out.println("Enter username: ");
				String username = input.nextLine();
				System.out.println("Enter password: ");
				String password = input.nextLine();
				userManager.registerUser(new User(username, password, "employee"));
				System.out.println("Done!");		
				adminEmployeeMenu();
				break;
			}
			case 2: {
				System.out.println("Enter username");
				String username = input.nextLine();
				System.out.println(userManager.readUser(username));
				System.out.println("Done!");
				adminEmployeeMenu();
				break;
			}
			case 3: {
				System.out.println("Enter username");
				String username = input.nextLine();
				System.out.println("Enter new username: ");
				String newUsername = input.nextLine();
				System.out.println("Enter new password: ");
				String newPass = input.nextLine();
				userManager.updateUser(username, new User(newUsername, newPass, "employee"));
				System.out.println("Done!");
				adminEmployeeMenu();
				break;
			}
			case 4: {
				System.out.println("Enter username: ");
				String username = input.nextLine();
				userManager.deleteUser(username);
				System.out.println("Done!");
				adminEmployeeMenu();
				break;
			}
			case 5:{
				adminMenu();
				break;
			}
			}
		} while (choice > 0 && choice <= 5);
	}

	@Override
	public void employeesMenu() throws InvalidCreditentialsException, IOException, Exception {
		Scanner input = new Scanner(System.in, "UTF-8");
		System.out.println("1. Books");
		System.out.println("2. Client");
		System.out.println("3. Exit");
		System.out.println("Enter your choice: ");
		int choice = input.nextInt();
		input.nextLine();
		do {
			switch (choice) {
			case 1:{
				IBookManager bookManager = new BookManager();			
				System.out.println("Enter title");
				String title = input.nextLine();
				System.out.println(bookManager.getBook(title));
				System.out.println("Done!");
				employeesMenu();
				break;
			}
			case 2:
				clientsMenu();
				break;
			case 3:
				break;
			}
		} while (choice > 0 && choice <= 3);
	}

	@Override
	public void clientsMenu() throws InvalidCreditentialsException, IOException, Exception {
		Scanner input = new Scanner(System.in, "UTF-8");
		int choice;
		IUserManager userManager = new UserManager();
		System.out.println("1. Add client");
		System.out.println("2. Read client");
		System.out.println("3. Update client");
		System.out.println("4. Delete client");
		System.out.println("5. Loan book");
		System.out.println("6. Exit");
		System.out.println("Enter your choice: ");
		choice = input.nextInt();
		input.nextLine();
		do {
			switch (choice) {
			case 1:{
				System.out.println("Enter username: ");
				String username = input.nextLine();
				userManager.registerUser(new User(username, "", "client"));
				System.out.println("Done!");
				clientsMenu();
				break;
			}
			case 2:{
				System.out.println("Enter username: ");
				String username = input.nextLine();
				System.out.println(userManager.readUser(username));
				System.out.println("Done");
				clientsMenu();
				break;
			}
			case 3:{
				System.out.println("Enter username: ");
				String username = input.nextLine();
				System.out.println("Enter new username: ");
				String newUsername = input.nextLine();
				userManager.updateUser(username, new User(newUsername, "", "client"));
				System.out.println("Done!");
				clientsMenu();
				break;
			}
			case 4:{
				System.out.println("Enter username: ");
				String username = input.nextLine();
				userManager.deleteUser(username);
				System.out.println("Done!");
				clientsMenu();
				break;
			}
			case 5:{
				ILoanManager lm = new LoanManager();
				System.out.println("Enter username: ");
				String username = input.nextLine();
				System.out.println("Enter title: ");
				String title = input.nextLine();
				lm.loanBook(username, title);
//				User user = userManager.readUser(username);
				clientsMenu();
				break;
			}
			case 6:{
				employeesMenu();
				break;
			}
			}
		} while (choice > 0 && choice <= 5);
	}

	private String[] getBookInfo() {
		Scanner input = new Scanner(System.in, "UTF-8");
		String[] arr = new String[6];

		System.out.println("Enter title: ");
		arr[0] = input.nextLine();
		System.out.println("Enter author: ");
		arr[1] = input.nextLine();
		System.out.println("Enter genre: ");
		arr[2] = input.nextLine();
		System.out.println("Enter number of pages: ");
		arr[3] = input.nextLine();
		System.out.println("Enter year: ");
		arr[4] = input.nextLine();
		System.out.println("Enter ISBN: ");
		arr[5] = input.nextLine();

		return arr;
	}
	
	void loanBook(String username, String title) throws SQLException{
		IUserManager um = new UserManager();
		IBookManager bm = new BookManager();
		User user = um.readUser(username);
		Book book = bm.getBook(title);
		if(user.getRole().equals("client")){
			if(book.getTitle() != null){
				
			}
		}
	}
}
