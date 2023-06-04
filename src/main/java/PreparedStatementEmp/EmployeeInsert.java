package PreparedStatementEmp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeInsert {
    public static void main(String[] args) {
        Connection con=null;
        PreparedStatement pstmt=null;
        String query="insert into emp values(?,?,?,?)";

        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja8", "root", "sql123");
            pstmt=con.prepareStatement(query);
            //1st record
            pstmt.setInt(1,0);
            pstmt.setString(2,"vijay");
            pstmt.setString(3,"HR");
            pstmt.setDouble(4,20000.25);
            int count1=pstmt.executeUpdate();

            //2nd record
            pstmt.setInt(1,0);
            pstmt.setString(2,"ajay");
            pstmt.setString(3,"admin");
            pstmt.setDouble(4,25000.25);
            int count2=pstmt.executeUpdate();
            //3rd record
            pstmt.setInt(1,0);
            pstmt.setString(2,"suresh");
            pstmt.setString(3,"developer");
            pstmt.setDouble(4,50000.25);
            int count3=pstmt.executeUpdate();
            System.out.println(count1+count2+count3+" record inserted successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
