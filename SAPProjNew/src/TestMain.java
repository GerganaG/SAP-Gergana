import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestMain{

	public final static String PATH_USERS = "C:\\Users\\geri\\Desktop\\SAP_Project\\Users.txt";
	public final static String PATH_BOOKS = "C:\\Users\\geri\\Desktop\\SAP_Project\\Books.txt";
	public static int COUNTER_USERS = 2;
	public static int COUNTER_BOOKS = 1;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

	Scanner scn = new Scanner(System.in, "UTF-8");
	System.out.println("Enter username: ");
	String username = scn.nextLine();
	System.out.println("Enter password: ");
	String password = scn.nextLine();
	
	User user = new User();	
	try {		
		if(user.loginUser(username, AESencrp.encrypt(password))){
			if(user.isUserInRole("administrator")){
				IAdminFunctionality admin = user;
				
				System.out.println("Administrator menu:\n1. Add book.\n2. Show books.\n"
						+ "3. Update informacion of a book.\n4. Remove book from library.\n"
						+ "5. Add employee.\n6. Show employees.\n7. Update information of an employee."
						+ "\n8. Remove employee.\n9. Exit.\n Enter your choice: ");
				
				int choice = scn.nextInt();
				scn.nextLine();
//				scn.close();
				
				switch(choice){
				case 1:			
					String arr1[] = BookInformation();
					admin.addBook(new Book(arr1[0], arr1[1], arr1[2], Integer.parseInt(arr1[3]), arr1[4]));
					break;
				case 2:
					System.out.println("Show books:");
					admin.showBooks();
					break;
				case 3: 
					System.out.println("Enter the book you want to update.");
					String arr2[] = BookInformation();
					admin.updateBook(new Book(arr2[0], arr2[1], arr2[2], Integer.parseInt(arr2[3]), arr2[4]));
					break;
				case 4: 
					System.out.println("Enter the book you want to remove.");
					String arr3[] = BookInformation();
					admin.removeBook(new Book(arr3[0], arr3[1], arr3[2], Integer.parseInt(arr3[3]), arr3[4]));
					break;
				case 5: 
					System.out.println("Add employy");
					break;
				case 6: 
					System.out.println("Show employees");
					break;
				case 7:
					System.out.println("Update employee");
					break;
				case 8:
					System.out.println("Remoove employee");
					break;
				case 9: break;
				default:
					System.out.println("Wrong choice!!!");
					break;
				}
	
			}else if(user.isUserInRole("employee")){
				IEmployeeFuctionality emp = user;
			}
		} else{
			System.out.println("There is not user with this username and password!!!");
		}
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
			
	}
	
	public static void writeToFile(String path, Object obj){
		try{
			if(path.equalsIgnoreCase(PATH_USERS) && obj instanceof User){
				ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream(path, true));         
				oout.writeObject((User) obj);
				oout.flush();
				oout.close();
			} else if(path.equalsIgnoreCase(PATH_BOOKS) && obj instanceof Book){
				ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream(path, true));         
				oout.writeObject((Book) obj);
				oout.flush();
				oout.close();
			}
			
		} catch(Exception exc){
			exc.printStackTrace();
		}
	}
	
	public static void rewriteUsers(ArrayList<User> list){
		try{
			ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream(PATH_USERS));    
			for(int i = 0; i < list.size(); i++){
				oout.writeObject((User)list.get(i));
			}
			oout.flush();
			oout.close();
		} catch(Exception exc){
			exc.printStackTrace();
		}
	}
	
	public static void rewriteBooks(ArrayList<Book> list){
		try{
		
			ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream(PATH_BOOKS));   
			for(int i = 0; i < list.size(); i++){
				oout.writeObject((Book)list.get(i));
			}
			oout.flush();
			oout.close();
				
		} catch(Exception exc){
			exc.printStackTrace();
		}
	}
	
	public static ArrayList<User> readFileUsers(){		
		ArrayList<User> list = new ArrayList<>();
		try{
			FileInputStream fis = new FileInputStream(PATH_USERS);	
			for(int i = 0; i < COUNTER_USERS; i++){
				ObjectInputStream oin = new ObjectInputStream(fis);
				Object temp = oin.readObject();    
				User user = (User) temp;
				list.add(user);
			}
			fis.close();		         
		}catch(Exception exc){
			exc.printStackTrace();
		}	
		return list;
	}
	
	public static ArrayList<Book> readFileBooks(){		
		ArrayList<Book> list = new ArrayList<>();
		try{
			FileInputStream fis = new FileInputStream(PATH_BOOKS);
			ObjectInputStream oin = new ObjectInputStream(fis);
			Book b = null;
			do{
				Object obj =  oin.readObject();
				b = (Book) obj;
				list.add(b);
				
			} while(b != null);
			
			
//			for(int i = 0; i < COUNTER_BOOKS; i++){
//				ObjectInputStream oin = new ObjectInputStream(fis);
//				Object temp = oin.readObject();    
//				Book book = (Book) temp;
//				list.add(book);
//			}
//			fis.close();	
//			InputStream file = new FileInputStream(PATH_BOOKS);
//			InputStream buffer = new BufferedInputStream(file);
//			ObjectInput input = new ObjectInputStream (buffer);
//		      //deserialize the List
//			List<Book> recoveredQuarks = (List<Book>)input.readObject();
//		      //display its data
//			for(Book quark: recoveredQuarks){
//				System.out.println("Recovered Quark: " + quark);
//			}
			
		}catch(Exception exc){
			exc.printStackTrace();
		}
		return list;
	}
	
	public static String[] BookInformation(){
		String[] array = new String[5];
		Scanner scan = new Scanner(System.in, "UTF-8");
		System.out.println("Enter title: ");
		String title = scan.nextLine();
		array[0] = title;
		System.out.println("Enter author: ");
		String author = scan.nextLine();
		array[1] = author;
		System.out.println("Enter genre: ");
		String genre = scan.nextLine();
		array[2] = genre;
		System.out.println("Enter pages: ");
		int pages = scan.nextInt();
		scan.nextLine();
		array[3] = "" + pages;
		System.out.println("Enter year: ");
		String year = scan.nextLine();
		array[4] = year;
		scan.close();
		return array;
	}
	
	
	
//	public static String readFile(String path){
//		StringBuilder sb = new StringBuilder();
//		try {
//			
//			FileReader fileReader = new FileReader(path);
//			
//			BufferedReader bufferedReader = new BufferedReader(fileReader);
//			
//			while (bufferedReader.ready()) {
//					String line = bufferedReader.readLine();
//					sb.append(line);
//					sb.append("\n");
//			}
//			bufferedReader.close();			
//			
//		} catch (Exception e) {
//			System.out.println("Error while reading a file.");
//			System.out.println(e.getMessage());
//			System.exit(0);
//		}
//		return sb.toString();
//	}
//	
//	public static void writeFile(String path, String string){
//		try {			
//			FileWriter fileStream = new FileWriter(path, true);
//			
//			BufferedWriter writer = new BufferedWriter(fileStream);		
//			
//			writer.write(string);
//			writer.newLine();
//			writer.close();
//			
//		} catch (Exception e) {
//			System.out.println("Error while writing a file.");
//			System.out.println(e.getMessage());
//			System.exit(0);
//		}
//	}

}
