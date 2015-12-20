import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class WriteToFile {
	
	private String path;
	private Object obj;

	public WriteToFile(String path, Object obj) {
		super();
		this.path = path;
		this.obj = obj;
	}

	public void writeToFile(){
		try{
			if(path.equalsIgnoreCase(TestMain.PATH_USERS) && obj instanceof User){
				ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream(path, true));         
				oout.writeObject((User) obj);
				oout.flush();
				oout.close();
			} else if(path.equalsIgnoreCase(TestMain.PATH_BOOKS) && obj instanceof Book){
				ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream(path, true));         
				oout.writeObject((Book) obj);
				oout.flush();
				oout.close();
			}
			
		} catch(Exception exc){
			exc.printStackTrace();
		}
	}

}
