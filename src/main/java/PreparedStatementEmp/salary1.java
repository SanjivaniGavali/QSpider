package PreparedStatementEmp;

import java.sql.*;

//business class
public class salary1 {

    void maxSal(){
        //code
        Connection con=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        String query="select * from emp where esalary=(select max(esalary) from emp)";
        try {
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja8","root","sql123");
            pstmt=con.prepareStatement(query);
            rs=pstmt.executeQuery();
            System.out.println("id\t\tname\t\tdesg\t\tsalary");
            while(rs.next()){
                int id=rs.getInt("eid");
                String name=rs.getString("ename");
                String desg=rs.getString("edesg");
                double salary=rs.getDouble("esalary");
                System.out.println(id+"\t\t"+name+"\t\t"+desg+"\t\t"+salary);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    void minSal(){
        Connection con=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        String query="select * from emp where esalary=(select min(esalary) from emp)";
        try {
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja8","root","sql123");
            pstmt=con.prepareStatement(query);
            rs=pstmt.executeQuery();
            System.out.println("id\t\tname\t\tdesg\t\tsalary");
            while(rs.next()){
                int id=rs.getInt("eid");
                String name=rs.getString("ename");
                String desg=rs.getString("edesg");
                double salary=rs.getDouble("esalary");
                System.out.println(id+"\t\t"+name+"\t\t"+desg+"\t\t"+salary);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
