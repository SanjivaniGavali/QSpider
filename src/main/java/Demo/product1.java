package Demo;

import java.sql.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class product1 {
    static Connection con=null;
    static int fqty=0;
    static{
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja8","root","sql123");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {

        boolean status=true;
        while(status){
            Scanner sc=new Scanner(System.in);
            System.out.println("SELECT\n1:display all product\n2:add to cart\n3:display all cart items\n4:remove items from cart\n5:update qty from cart\n6:Exit");
            int choice=sc.nextInt();
            switch (choice){
                case 1:
                    displayProd();
                    break;
                case 2:
                    System.out.println("Enter product name");
                    String name=sc.next();
                    try {
                        System.out.println("Enter qty");
                        int qty=sc.nextInt();
                        addToCart(name,qty);
                    }catch (InputMismatchException e){
                        System.out.println(e);
                    }

                    break;
                case 3:
                    displayCart();
                    break;
                case 4:
                    System.out.println("Enter product name");
                    String cname=sc.next();
                    removeItemsCart(cname);
                    break;
                case 5:
                    updateQty();
                    break;
                case 6:
                    System.out.println("Thank u for visiting");
                    status=false;

            }


        }
    }
    static void displayProd(){
       // Connection con=null;
        Statement stmt=null;
        ResultSet res=null;
        String query="select * from product";

        try {
           // con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja8","root","sql123");
            stmt=con.createStatement();
            res= stmt.executeQuery(query);
            System.out.println("id\t\tname\t\tqty\t\tprice");
            System.out.println("=========================");
            while(res.next()){
                int pid=res.getInt(1);
                String pname=res.getString(2);
                int pqty=res.getInt(3);
                double price=res.getDouble(4);
                System.out.println(pid+"\t\t"+pname+"\t\t"+pqty+"\t\t"+price);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    static void addToCart(String product_name,int qty){
        //code
        Statement stmt=null;
        ResultSet rs=null;
        fqty+=qty;
        String query="select pname,pqty,price from product where pname='"+product_name+"'";
        try {
            stmt=con.createStatement();
            rs=stmt.executeQuery(query);
            if(rs.next()){
                if(qty<=rs.getInt(2)){
                    String queryForCart="insert into cart values('"+rs.getString(1)+"',"+qty+","+rs.getDouble(3)+")";
                   int count= stmt.executeUpdate(queryForCart);
                   if(count!=0){
                       System.out.println("items added to cart");
                   }else{
                       System.out.println("items not added to cart");
                   }
                }else{
                    System.out.println("Out of stock");
                }
              //  String pname=rs.getString(1);
               // double price=rs.getDouble(3);
               // System.out.println(pname+"\t\t"+pqty+"\t\t"+price);
            }else{
                System.out.println("Product is not available");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    static void displayCart(){
        Connection con=null;
        Statement stmt=null;
        ResultSet res=null;
        String query="select * from cart";

        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja8","root","sql123");
            stmt=con.createStatement();
            res= stmt.executeQuery(query);
            System.out.println("name\t\tqty\t\tprice");
            System.out.println("=========================");
            while(res.next()){
                String name=res.getString(1);
                int qty=res.getInt(2);
                double price=res.getDouble(3);
                System.out.println(name+"\t\t"+qty+"\t\t"+price);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    static void removeItemsCart(String product_name){
        Connection con=null;
        Statement stmt=null;
        String query="Delete from cart where name='"+product_name+"'";
        try {
            //2 step
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja8","root","sql123");
            stmt=con.createStatement();
            int count=stmt.executeUpdate(query);
            System.out.println(count+" item DELETED SUCCESSFULLY");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if(con!=null){
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(stmt!=null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    static void updateQty(){
        System.out.println(fqty+" qty available in cart");
    }

}
