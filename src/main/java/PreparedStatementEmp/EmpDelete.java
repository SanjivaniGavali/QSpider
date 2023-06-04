package PreparedStatementEmp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmpDelete {
    public static void main(String[] args) {
        Connection con=null;
        PreparedStatement pstmt=null;
        String query="delete from emp where eid=?";

        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja8", "root", "sql123");
            pstmt=con.prepareStatement(query);
            //1st record
            pstmt.setInt(1,1);
            int count1=pstmt.executeUpdate();
            //2nd record
            pstmt.setInt(1,2);
            int count2=pstmt.executeUpdate();
            System.out.println(count1+count2+" record deleted successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
