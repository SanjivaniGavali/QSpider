package EmployeeOperation;

import java.util.Scanner;

public class MainApp1 {
    public static void main(String[] args) {
        Employee1 e1=new Employee1();
        Scanner sc=new Scanner(System.in);
        System.out.println("Select Your Choice\n1:LOGIN\n2:SIGNUP");
        int choice=sc.nextInt();
        if(choice==1){
            System.out.println("Enter Username");
            String name=sc.next();
            System.out.println("Enter Password");
            String pass=sc.next();
            boolean status=e1.logIn(name,pass);
            if(status==true){
                System.out.println("Enter Your Choice\n1:Add Employee\n2:View Employee");
                int type=sc.nextInt();
                if(type==1){
                    System.out.println("Enter name");
                    String ename=sc.next();
                    System.out.println("Enter designation");
                    String desg=sc.next();
                    System.out.println("Enter Salary");
                    double sal= sc.nextDouble();
                    e1.addEmp(ename,desg,sal);
                } else if (type==2) {
                    e1.displayEmp();

                }else {
                    System.out.println("Invalid Choice");
                }
            }else {
                System.out.println("Invalid Credentials");
                System.out.println("Select Your Choice\n1:SIGNUP\n2:Exit");
                int type2= sc.nextInt();
                if(type2==1){
                    System.out.println("Enter username");
                    String user=sc.next();
                    System.out.println("Enter Password");
                    String pas=sc.next();
                    e1.signup(user,pas);
                } else if (type2==2) {
                    System.out.println("Thank You For Visiting!");
                }
            }

        } else if (choice==2) {
            System.out.println("Enetr username");
            String user=sc.next();
            System.out.println("Enter Password");
            String pass=sc.next();
            e1.signup(user,pass);
        }else {
            System.out.println("Invalid Choice");
        }
    }
}
