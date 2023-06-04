package Course_Info;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertCource {
    public static void main(String[] args) {
        Connection con=null;
        PreparedStatement pstmt=null;
        InputStream fin=null;

        String query="insert into course_info values(?,?,?)";

        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja8","root","sql123");
            pstmt= con.prepareStatement(query);
            pstmt.setInt(1,0);
            pstmt.setString(2,"WT");
            fin=new FileInputStream("F:\\1EJAA8data\\J2EE\\html.jpeg");
            pstmt.setBinaryStream(3,fin);
            int count= pstmt.executeUpdate();
            System.out.println(count+" record inserted successfully");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
