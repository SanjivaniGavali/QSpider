package Transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Demo1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Book Id");
        int id=sc.nextInt();
        Connection con=null;
        PreparedStatement pstmt=null;
        String query="delete from book_info where book_id=?";

        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja8","root","sql123");
            con.setAutoCommit(false);
            pstmt=con.prepareStatement(query);
            pstmt.setInt(1,id);
            int count=pstmt.executeUpdate();
            System.out.println("Are u sure");
            System.out.println("1:YES\n2:NO");
            int choice= sc.nextInt();
            if(choice==1){
                con.commit();
                System.out.println(count+" book deleted successfully");
            }else{
                con.rollback();
                System.out.println("Transaction Cancelled");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
