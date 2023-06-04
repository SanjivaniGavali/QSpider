package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class jdbc4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Id");
        int id = sc.nextInt();
        System.out.println("Enter Choice for update\n1:update name\n2:update salary");
        int choice = sc.nextInt();
        String name = null;
        double sal = 0;
        if (choice == 1) {
            System.out.println("Enter name");
            name = sc.next();
        } else {
            System.out.println("Enter salary");
            sal = sc.nextDouble();
        }
        Connection con = null;
        Statement stmt = null;
        String query1 = "update emp set ename='" + name + "' where eid=1";
        String query2 = "update emp set esalary=" + sal + " where eid=1";
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja8", "root", "sql123");
            stmt = con.createStatement();
            if (choice == 1) {
                int count = stmt.executeUpdate(query1);
                System.out.println(count + " record updated successfully");
            } else {
                int count = stmt.executeUpdate(query2);
                System.out.println(count + " record updated successfully");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
