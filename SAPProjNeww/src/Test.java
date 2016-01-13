
import java.sql.Date;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Test {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
//		ArrayList<User> listOfUsers = new ArrayList<>();
//		ResultSet rs = MySQLAccess.conectToDBForRead("select * from user");
//		while(rs.next()){
//			String uName = rs.getString("username");
//			String uPass = rs.getString("user_pass");
//			String role = rs.getString("role");
//			listOfUsers.add(new User(uName, uPass, role));	
//		}
//		
//		for (User user : listOfUsers) {
//			System.out.println(user.toString());
//		}
//		
//		MySQLAccess.conectToDB("insert into user(username, user_pass, role) values ('maq93', '930822', 'admin')");
//		
//		System.out.println();
//		System.out.println();
//		System.out.println();
//		ArrayList<User> newList = new ArrayList<>();
//		ResultSet rs3 = MySQLAccess.conectToDBForRead("select * from user");
//		while(rs3.next()){
//			String uName = rs3.getString("username");
//			String uPass = rs3.getString("user_pass");
//			String role = rs3.getString("role");
//			newList.add(new User(uName, uPass, role));	
//		}
//		
//		for (User user : newList) {
//			System.out.println(user);
//		}
		
//		BookManager bm = new BookManager();
//		bm.addBook(new Book("title", "autho", "genre", 200, "2000", "AA55"));
//		ArrayList<Book> arrList = bm.readBook();
//		for (Book book : arrList) {
//			System.out.println(book);
//		}
//		Book b = bm.getBook("title");
//		System.out.println(b);
		
//		bm.updateBook("lala", new Book("newT", "newA", "newG", 300, "2001", "AA88"));
		
//		bm.deleteBook("newT");
//		
//		UserManager um = new UserManager();
//		
////		User u = um.readUser("admin");
////		System.out.println(u);
//		
//		//um.registerUser(new User("Georgi", "Dimitrov", "employee"));
//		//um.updateUser("Georgi", new User("Stefan", "Stefanov", "employee"));
////		um.deleteUser("Stefan");
//		
//		
//		Login lg = new Login();
//		
//		String pass = "admin123";
//		String username = "admin";
////		System.out.println(lg.loginUser(username, AESencrp.encrypt(pass)));
//		if(lg.loginUser(username, AESencrp.encrypt(pass))){
//			String role = lg.isUserInRole(username);
//			System.out.println(role);
//		} else{
//			System.out.println("wrong");
//		}
		
//		&& u.getPassword().equals(password)
	}
}
