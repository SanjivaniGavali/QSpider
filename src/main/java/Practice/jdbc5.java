package Practice;

import java.sql.*;

public class jdbc5 {
    public static void main(String[] args) {
        Connection con=null;
        Statement stmt=null;
        ResultSet rs=null;
        String query="select * from emp";


        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja8","root","sql123");
            stmt=con.createStatement();
            rs=stmt.executeQuery(query);
            System.out.println("ID\t\tNAME\t\tDESG\t\tSALARY");
            System.out.println("=====================================================");
            while (rs.next()){
                int id=rs.getInt(1);
                String name=rs.getString(2);
                String desg=rs.getString(3);
                double salary=rs.getDouble(4);
                System.out.println(id+"\t\t"+name+"\t\t"+desg+"\t\t"+salary);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
