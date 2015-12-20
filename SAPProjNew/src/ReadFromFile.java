import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class ReadFromFile {

	public ArrayList<User> readFileUsers(){		
		ArrayList<User> list = new ArrayList<>();
		try{
			FileInputStream fis = new FileInputStream(TestMain.PATH_USERS);	
			for(int i = 0; i < TestMain.COUNTER_USERS; i++){
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
	
	public ArrayList<Book> readFileBooks(){		
		ArrayList<Book> list = new ArrayList<>();
		try{
			FileInputStream fis = new FileInputStream(TestMain.PATH_BOOKS);
			ObjectInputStream oin = new ObjectInputStream(fis);
			Book b = null;
			do{
				Object obj =  oin.readObject();
				b = (Book) obj;
				list.add(b);
				
			} while(b != null);
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return list;
	}
}
