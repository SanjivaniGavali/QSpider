package Demo;

import java.sql.*;
import java.util.Scanner;

public class FetchSpecificBook {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Book Id");
        int id=sc.nextInt();
        Connection con=null;
        Statement stmt=null;
        ResultSet rs=null;
        String query="select book_id,book_name,book_price from book_info where book_id= "+id;

        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja8","root","sql123");
            stmt= con.createStatement();
            rs=stmt.executeQuery(query);
            System.out.println("book_id\tbook_name\tbook_price");
            while (rs.next()){
                int id1=rs.getInt(1);
                String name=rs.getString(2);
                double price=rs.getDouble(3);
                System.out.println(id1+"\t\t"+name+"\t\t"+price);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
