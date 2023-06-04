package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class jdbc3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter user id");
        int id=sc.nextInt();
        System.out.println("Enter name");
        String name= sc.next();
        System.out.println("Enter desg");
        String desg= sc.next();
        System.out.println("Enter salary");
        double sal=sc.nextDouble();
        Connection con=null;
        Statement stmt=null;
        String query="insert into emp values("+id+",'"+name+"','"+desg+"',"+sal+")";

        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja8","root","sql123");
            stmt=con.createStatement();
            int count= stmt.executeUpdate(query);
            System.out.println(count+" record inserted successfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
