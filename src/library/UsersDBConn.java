package library;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersDBConn {
    
    
    public static boolean validate(String name,String password){
		boolean status=false;
		try{
                    try (Connection con = DB.getConnection()) {
                        PreparedStatement ps=con.prepareStatement("select * from Users where UserName=? and UserPass=?");
                        ps.setString(1,name);
                        ps.setString(2,password);
                        ResultSet rs=ps.executeQuery();
                        status=rs.next();
                    }
		}catch(SQLException e){System.out.println(e);}
		return status;
	}
    
    public static boolean CheckIfAlready(String UserName)
    {
        boolean status=false;
		try{
            try (Connection con = DB.getConnection()) {
                PreparedStatement ps=con.prepareStatement("select * from Users where UserName=?");
                ps.setString(1,UserName);
                ResultSet rs=ps.executeQuery();
                status=rs.next();
            }
		}catch(SQLException e){System.out.println(e);}
		return status;
        
    }
    
    

    public  static int AddUser(String User, String UserPass, String UserEmail, String Date, String MatricsNum) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       
         int status =0;
         try{
        
             try (Connection con = DB.getConnection()) {
                 PreparedStatement ps= con.prepareStatement("insert into Users(UserPass,RegDate,UserName,MatricsNo,Email) values(?,?,?,?,?)");
                 ps.setString(1,UserPass);
                 ps.setString(2,Date);
                 ps.setString(3,User);
                 ps.setString(4,MatricsNum);
                 ps.setString(5,UserEmail);
                 status =ps.executeUpdate();
             }
}catch(SQLException e){System.out.println(e);}
    return status; 
    
    
    }

    
}
