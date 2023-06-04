package Demo;

import java.sql.*;

public class DisplayBook {
    public static void main(String[] args) {
        Connection con=null;
        Statement stmt=null;
        ResultSet res=null;
        String query="select * from book_info";

        try {
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja8","root","sql123");
            stmt=con.createStatement();
            res= stmt.executeQuery(query);
            System.out.println("id\t\tname\t\tprice");
            System.out.println("=========================");
            while(res.next()){
                int id=res.getInt(1);
                String name=res.getString(2);
                double price=res.getDouble(3);
                System.out.println(id+"\t\t"+name+"\t\t"+price);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
