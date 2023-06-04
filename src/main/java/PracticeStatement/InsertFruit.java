package PracticeStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertFruit {
    public static void main(String[] args) {
        Connection con=null;
        Statement stmt=null;
        String query="insert into fruit values(0,'pineapple',20.90)";

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