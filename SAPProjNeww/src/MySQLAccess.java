import java.sql.*;

public class MySQLAccess {

	private final static String URL = "jdbc:mysql://localhost:3306/library?useSSL=false";
	private final static String USER = "root";
	private final static String PASSWORD = "root";
	private static Connection connect = null;
	private static Statement statement = null;
	private static ResultSet resultSet = null;

//	static {
//		try {
//			connect = DriverManager.getConnection(URL, USER, PASSWORD);			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
	public static Connection getConnection(){
		try {
			connect = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connect;
	}

	public static ResultSet getResultSet(String query) {

		try {
			connect = DriverManager.getConnection(URL, USER, PASSWORD);
			statement = connect.createStatement();
			resultSet = statement.executeQuery(query);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultSet;
	}
	
//	public static void conectToDB(String query) throws Exception {
//
//		try {
//			prStatement = connect.prepareStatement(query);
//			prStatement.executeUpdate();
//		} catch (Exception e) {
//			throw e;
//		}
//	}
	

}

// public static void main(String[] args) {
//
// try {

/*
 * read from table
 */

// ResultSet myRs = myStmt.executeQuery("select * from user");
//
// while(myRs.next()){
// System.out.println(myRs.getString("username") + ", "
// + myRs.getString("password") + ", "
// + myRs.getInt("fk_user_role"));
// }

/*
 * add objects into table
 */
// String add = "insert into user"
// + "(username, password, fk_user_role)"
// + "values ('maq93', '930822', '3')";
//
// myStmt.executeUpdate(add);
//
// System.out.println("End adding");

/*
 * update object
 */
// String update = "update user "
// + "set password='newpw' "
// + "where user_id = 4";
//
// myStmt.executeUpdate(update);
//
// System.out.println("Update complete");

/*
 * delete statement
 */

// String delete = "delete from user where user_id=4";
//
// int rowsAffected = myStmt.executeUpdate(delete);
//
// System.out.println("Rows affected:" + rowsAffected);
// System.out.println("DElete is comlete");
//
// } catch (Exception e) {
// e.printStackTrace();
// }
// }
