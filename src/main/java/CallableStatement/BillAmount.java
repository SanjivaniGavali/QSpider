package CallableStatement;

import java.sql.*;
import java.util.Scanner;

public class BillAmount {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter quantity");
        int qty= sc.nextInt();
        System.out.println("Enter price");
        double price= sc.nextDouble();
        Connection con=null;
        CallableStatement cstmt=null;

        try {
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja8","root","sql123");
            cstmt= con.prepareCall("{?=call billamount(?,?)}");
            cstmt.setInt(2,qty);
            cstmt.setDouble(3,price);
            cstmt.registerOutParameter(1, Types.DOUBLE);
            cstmt.execute();
            System.out.println("TotalBill==>"+cstmt.getString(1));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
