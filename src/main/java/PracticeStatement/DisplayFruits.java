package PracticeStatement;

import java.sql.*;

public class DisplayFruits {
    public static void main(String[] args) {
        Connection con=null;
        Statement stmt=null;
        ResultSet rs=null;
        String query="select * from fruit";

        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1ccm24","root","sql123");
            stmt= con.createStatement();
            rs=stmt.executeQuery(query);
            System.out.println("ID\t\tNAME\t\tPRICE");
            while (rs.next()){
                int id=rs.getInt(1);
                String name=rs.getString(2);
                double price=rs.getDouble(3);
                System.out.println(id+"\t\t"+name+"\t\t"+price);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
