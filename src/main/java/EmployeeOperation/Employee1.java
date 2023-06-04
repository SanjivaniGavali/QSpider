package EmployeeOperation;

import java.sql.*;

public class Employee1 {
    public boolean logIn(String name, String pass) {
        Connection con=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        boolean status=false;
        String query="select* from login_info";
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja8","root","sql123");
            pstmt=con.prepareStatement(query);
            rs=pstmt.executeQuery();
            while(rs.next()){
                String dbuser=rs.getString("username");
                String dbpass=rs.getString("password");
                if(dbuser.equals(name) && dbpass.equals(pass)){
                    status=true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    public void addEmp(String ename, String desg, double sal) {
        Connection con=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;

        String query="insert into employee values(?,?,?,?)";
        try {
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja8","root","sql123");
            pstmt=con.prepareStatement(query);
            pstmt.setInt(1,0);
            pstmt.setString(2,ename);
            pstmt.setString(3,desg);
            pstmt.setDouble(4,sal);
            int count=pstmt.executeUpdate();
            System.out.println(count+" record inserted successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void displayEmp(){
        Connection con=null;
        Statement pstmt=null;
        ResultSet rs=null;

        String query="select * from employee";
        try {
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja8","root","sql123");
            pstmt=con.createStatement();
            rs= pstmt.executeQuery(query);
            System.out.println("id\t\tname\t\tdesg\t\tsalary");
            System.out.println("======================================");
            while (rs.next()){
                int id=rs.getInt(1);
                String name=rs.getString(2);
                String desg=rs.getString(3);
                double sal=rs.getDouble(4);
                System.out.println(id+"\t\t"+name+"\t\t"+desg+"\t\t"+sal);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void signup(String user, String pass) {
        Connection con=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;

        String query="insert into login_info values(?,?,?)";
        try {
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja8","root","sql123");
            pstmt=con.prepareStatement(query);
            pstmt.setInt(1,0);
            pstmt.setString(2,user);
            pstmt.setString(3,pass);
            int count=pstmt.executeUpdate();
            System.out.println(count+" Registration Successful");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
