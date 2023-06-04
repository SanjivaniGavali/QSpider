package Demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateBookDynamically {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Book ID");
        int id = sc.nextInt();
        System.out.println("Enter A Which Field is Updated?\n1:Book Name\n2:Book Price");
        int choice = sc.nextInt();
        String name = null;
        double price = 0;
        if (choice == 1) {
            System.out.println("Enter Book Name");
            name = sc.next();
        } else if (choice == 2) {
            System.out.println("Book Price");
            price = sc.nextDouble();
        }


        Connection con = null;
        Statement stmt = null;
        String query1 = "update book_info set book_name='" + name + "' where book_id= "+ id;
        String query2 = "update book_info set book_price=" + price + " where book_id= "+ id;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja8", "root", "sql123");

            stmt = con.createStatement();
            if(choice==1){
                int count1=stmt.executeUpdate(query1);
                System.out.println(count1+" Book updated");
            }else{
                int count2=stmt.executeUpdate(query2);
                System.out.println(count2+" Book updated");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
