package PreparedStatementEmp;

import java.sql.*;
import java.util.Scanner;

public class login_info {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter username");
        String name=sc.next();
        System.out.println("Enter password");
        String pass=sc.next();
        Connection con=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        String query="select * from login_info where username=? and password=?";


        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja8", "root", "sql123");
            pstmt=con.prepareStatement(query);
            pstmt.setString(1,name);
            pstmt.setString(2,pass);
            rs=pstmt.executeQuery();
            if(rs.next()){
                System.out.println("login successful");
            }else {
                System.out.println("login fail");
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
