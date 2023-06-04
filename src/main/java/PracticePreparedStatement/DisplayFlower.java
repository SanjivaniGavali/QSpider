package PracticePreparedStatement;

import java.sql.*;

public class DisplayFlower {
    public static void main(String[] args) {
        Connection con=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;

        String query="select * from flower";

        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1ccm24","root","sql123");
            pstmt=con.prepareStatement(query);
            rs= pstmt.executeQuery();
            System.out.println("id\t\tname\t\tprice");
            System.out.println("=====================================");
            while (rs.next()){
                int id=rs.getInt(1);
                String name= rs.getString(2);
                double price=rs.getDouble(3);
                System.out.println(id+"\t\t"+name+"\t\t"+price);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
