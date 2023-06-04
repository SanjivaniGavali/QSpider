package PracticeStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertBookDynamically {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter id");
        int id=sc.nextInt();
        System.out.println("Enter name");
        String name= sc.next();
        System.out.println("Enter price");
        double price=sc.nextDouble();
        Connection con=null;
        Statement stmt=null;
        String query="insert into fruit values("+id+",'"+name+"',"+price+")";

        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1ccm24","root","sql123");
            stmt=con.createStatement();
            stmt.executeUpdate(query);
            int count= stmt.getUpdateCount();
            System.out.println(count+" record inserted");



        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
