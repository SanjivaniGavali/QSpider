package CallableStatement;

import java.sql.*;
import java.util.Collections;
import java.util.Scanner;

public class AddNumberFun {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter first Number");
        int n1=sc.nextInt();
        System.out.println("Enter second Number");
        int n2=sc.nextInt();
        Connection con=null;
        CallableStatement cstmt=null;

        try {
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja8","root","sql123");
            cstmt= con.prepareCall("{?=call addnumbers(?,?)}");
            cstmt.setInt(2,n1);
            cstmt.setInt(3,n2);
            cstmt.registerOutParameter(1, Types.INTEGER);
            cstmt.execute();
            System.out.println("Addition is:"+cstmt.getInt(1));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
