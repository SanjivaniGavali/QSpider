package Practice;

import java.sql.*;

public class jdbc9 {
    public static void main(String[] args) {
        Connection con=null;
        Statement stmt=null;
        ResultSet rs=null;
        String query="select count(eid) from emp";
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja8","root","sql123");
            stmt=con.createStatement();
            rs=stmt.executeQuery(query);
//            System.out.println(count+" record deleted successfully");
            while (rs.next()){
                int count=rs.getInt(1);
                System.out.println("Total No Of Emp="+count);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
