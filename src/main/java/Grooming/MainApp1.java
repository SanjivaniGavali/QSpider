package Grooming;

import java.util.ArrayList;
import java.util.Scanner;

public class MainApp1 {

    public static void main(String[] args) {
        ArrayList<Customer> data=new ArrayList<>();
        for(int i=0;i<3;i++){
            Customer c=createCustomer();
            data.add(c);
        }
        for (Customer c:data){
            System.out.println(c);
        }
    }
    public static Customer createCustomer(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter ID");
        int id= sc.nextInt();
        System.out.println("Enter Name");
        String name= sc.next();
        System.out.println("Enter Age");
        int age= sc.nextInt();
        return new Customer(id,name,age);
    }
}
