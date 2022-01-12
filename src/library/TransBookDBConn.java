package library;

import java.sql.*;
//import javax.swing.JTextField;

public class TransBookDBConn {

    public static boolean checkBook(String bookcallno) {
        boolean status = false;
        try {
            try (Connection con = DB.getConnection()) {
                PreparedStatement ps = con.prepareStatement("select * from Books where BookID=?");
                ps.setString(1, bookcallno);
                ResultSet rs = ps.executeQuery();
                status = rs.next();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return status;
    }

    public static boolean BookValidate(String BookID) {
        boolean status = false;
        try (Connection con = DB.getConnection()) {
            PreparedStatement ps = con.prepareStatement("select * from Books where BookID = ?");
            ps.setString(1, BookID);
            ResultSet rs = ps.executeQuery();
            status = rs.next();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }

    public static boolean UserValidate(String MatricsNo) {
        boolean status = false;
        try (Connection con = DB.getConnection()) {
            PreparedStatement ps = con.prepareStatement("select * from Users where MatricsNo = ?");
            ps.setString(1, MatricsNo);
            ResultSet rs = ps.executeQuery();
            status = rs.next();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }

    public static int updatebook(String bookcallno) {
        int status = 0;
        int quantity = 0, issued = 0;
        try {
            try (Connection con = DB.getConnection()) {
                PreparedStatement ps = con.prepareStatement("select quantity,issued from books where callno=?");
                ps.setString(1, bookcallno);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    quantity = rs.getInt("quantity");
                    issued = rs.getInt("issued");
                }

                if (quantity > 0) {
                    PreparedStatement ps2 = con.prepareStatement("update books set quantity=?,issued=? where callno=?");
                    ps2.setInt(1, quantity - 1);
                    ps2.setInt(2, issued + 1);
                    ps2.setString(3, bookcallno);

                    status = ps2.executeUpdate();
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return status;
    }

    public static int IssueBook(int BookID, String MatricsNo, String IDate, String RDate) {
        int status = 0;
        try {

            try (Connection con = DB.getConnection()) {
                PreparedStatement ps = con.prepareStatement("insert into IssuedBook values(?,?,?,?)");
                ps.setInt(1, BookID);
                ps.setString(2, MatricsNo);
                ps.setString(3, IDate);
                ps.setString(4, RDate);
                status = ps.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return status;
    }

    public static int ReturnBook(int BookID, String MatricsNo) {
        int status = 0;
        try {

            try (Connection con = DB.getConnection()) {
                PreparedStatement ps = con.prepareStatement("delete from IssuedBook where BookID=? and MatricsNo=?");
                ps.setInt(1, BookID);
                ps.setString(2, MatricsNo);
                status = ps.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return status;
    }

    public static boolean CheckIssuedBook(int BookID) {
        boolean status = false;
        try (Connection con = DB.getConnection()) {
            PreparedStatement ps = con.prepareStatement("select * from IssuedBook  where BookID=?");
            ps.setInt(1, BookID);
            ResultSet rs = ps.executeQuery();
            status = rs.next();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }

    public static int Check(String MatricsNo) {
        boolean status = false;
        int num = 0;
        try (Connection con = DB.getConnection()) {
            PreparedStatement ps = con.prepareStatement("select * from Book_Count MatricsNo=?");
            ps.setString(2, MatricsNo);
            ResultSet rs = ps.executeQuery();
            status = rs.next();
            num = rs.getInt("BookNo");
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        if (num == 5) {
            return 0;
        } else {
            return 1;
        }
    }

    /*
     * static int Check(String MatricsNoIDV) {
     * throw new UnsupportedOperationException("Not supported yet."); // Generated
     * from
     * nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
     * }
     * 
     * static int IssueBook(int BookIDV, String MatricsNoIDV, String IFDate, String
     * RFDate) {
     * throw new UnsupportedOperationException("Not supported yet."); // Generated
     * from
     * nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
     * }
     */

}
