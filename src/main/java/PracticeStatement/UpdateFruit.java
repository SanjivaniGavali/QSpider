package PracticeStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateFruit {
    public static void main(String[] args) {
        Connection con=null;
        Statement stmt=null;
        String query="update  fruit set name='banana' where id=1";


        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1ccm24","root","sql123");
            stmt=con.createStatement();
            stmt.executeUpdate(query);
            int count= stmt.getUpdateCount();
            System.out.println(count+" record updated");



        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
