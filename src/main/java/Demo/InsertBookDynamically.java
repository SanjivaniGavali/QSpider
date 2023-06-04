package Demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertBookDynamically {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Book ID");
        int id=sc.nextInt();
        System.out.println("Enter Book Name");
        String name=sc.next();
        System.out.println("Enter Book Price");
        double price=sc.nextDouble();

        Connection con=null;
        Statement stmt=null;
        String query="insert into book_info values("+id+",'"+name+"',"+price+")";
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja8","root","sql123");

            stmt= con.createStatement();
            int count=stmt.executeUpdate(query);
            System.out.println(count+" Book Inserted");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
