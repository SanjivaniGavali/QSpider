package PracticePreparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertFruitDynamically {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter id");
        int id= sc.nextInt();
        System.out.println("Enter name");
        String name=sc.next();
        System.out.println("Enter price");
        double price=sc.nextDouble();
        Connection con=null;
        PreparedStatement pstmt=null;
        String query="insert into flower values(?,?,?)";

        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1ccm24","root","sql123");
            pstmt=con.prepareStatement(query);
            pstmt.setInt(1,id);
            pstmt.setString(2,name);
            pstmt.setDouble(3,price);
            int count= pstmt.executeUpdate();
            System.out.println(count+" record inserted");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
