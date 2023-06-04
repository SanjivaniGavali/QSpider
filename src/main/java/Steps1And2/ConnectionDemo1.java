package Steps1And2;

import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDemo1 {
    public static void main(String[] args) {
//
        try {
            DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja8","root","sql123");
            System.out.println("Connection Successful");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
