package PracticePreparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertFruit {
    public static void main(String[] args) {
        Connection con=null;
        PreparedStatement pstmt=null;
        String query="insert into flower values(?,?,?)";

        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1ccm24","root","sql123");
            pstmt=con.prepareStatement(query);
            pstmt.setInt(1,0);
            pstmt.setString(2,"rose");
            pstmt.setDouble(3,20);
            int count= pstmt.executeUpdate();
            System.out.println(count+" record inserted");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
