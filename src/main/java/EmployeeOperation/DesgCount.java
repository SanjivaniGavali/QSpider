package EmployeeOperation;

import java.sql.*;
import java.util.Scanner;

public class DesgCount {
    public static void main(String[] args) {
        Connection con=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Designation");
        String desg=sc.next();
        String query="select count(*) from employee where desg=?";
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja8","root","sql123");
            pstmt=con.prepareStatement(query);
            pstmt.setString(1,desg);
            rs=pstmt.executeQuery();
           while (rs.next()){
               int count=rs.getInt(1);
               System.out.println(count);
            }
            System.out.println();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
