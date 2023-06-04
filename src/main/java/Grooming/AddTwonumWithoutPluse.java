package Grooming;

import java.util.Scanner;

public class AddTwonumWithoutPluse {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter First Number");
        int n1= sc.nextInt();
        System.out.println("Enter Second Number");
        int n2= sc.nextInt();
        while (n2!=0){
            n1++;
            n2--;
        }
        System.out.println("Total Addition:"+n1);

        //=======================================================================================

        //subtraction
        System.out.println("Enter First Number");
        int x= sc.nextInt();
        System.out.println("Enter Second Number");
        int y= sc.nextInt();
        int max=Math.max(x,y);
        int min=Math.min(x,y);
       while (max>min){
           max--;
//           System.out.println(max);
       }
        System.out.println("Subtraction:"+max);

    }

}
