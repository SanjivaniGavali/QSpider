package PreparedStatementEmp;

import java.sql.*;
import java.util.Scanner;

public class login_info2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter username");
        String name=sc.next();
        System.out.println("Enter password");
        String pass=sc.next();
        Connection con=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        String query="select * from login_info";


        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja8", "root", "sql123");
            pstmt=con.prepareStatement(query);
            rs=pstmt.executeQuery();
            boolean status=false;
            while (rs.next()){
                String dbuser=rs.getString("username");
                String dbpass=rs.getString("password");
                if(dbuser.equals(name) && dbpass.equals(pass)){
                    System.out.println("login successful");
                    status=true;
                }

            }
            if(!status) {
                System.out.println("login fail");
            }



        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
