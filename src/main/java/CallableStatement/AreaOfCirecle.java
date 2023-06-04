package CallableStatement;

import java.sql.*;
import java.util.Scanner;

public class AreaOfCirecle {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter radius");
        double n1=sc.nextDouble();
        Connection con=null;
        CallableStatement cstmt=null;

        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja8","root","sql123");
            cstmt= con.prepareCall("{?=call areaofcircle(?)}");
            cstmt.setDouble(2,n1);
            cstmt.registerOutParameter(1, Types.DOUBLE);
            cstmt.execute();
            System.out.println("AREA is:"+cstmt.getDouble(1));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
