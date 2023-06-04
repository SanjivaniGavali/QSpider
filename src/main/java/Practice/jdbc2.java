package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbc2 {
    public static void main(String[] args) {
        Connection con=null;
        Statement stmt=null;
        String query="delete from emp where eid=13";
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja8","root","sql123");
            stmt=con.createStatement();
            int count= stmt.executeUpdate(query);
            System.out.println(count+" record deleted successfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
