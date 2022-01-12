package library;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class DB {
    

	public static Connection getConnection(){
		Connection con=null;
		try{
                            Properties props = new Properties(); 
    props.put("user", "root");         
    props.put("password", "");
    props.put("useUnicode", "true");
    props.put("useServerPrepStmts", "false"); // use client-side prepared statement
    props.put("characterEncoding", "UTF-8"); // ensure charset is utf8 here

			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library",props);
		}catch(ClassNotFoundException | SQLException e){System.out.println(e);}
		return con;
	}

}