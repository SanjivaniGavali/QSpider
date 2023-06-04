package Grooming;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SubString1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Substring");
        String substr=sc.next();
        String str="madam";
        int n1=str.length();
       int n2=substr.length();
        Set<String> set=new LinkedHashSet<>();
        //   ***************logic***************
        for(int i=0;i<n1;i++){
            String temp="";
            for(int j=i;j<n1;j++){
               temp+=str.charAt(j);
               set.add(temp);
            }
        }
       if(set.contains(substr)){
           System.out.println(true);
       }else
           System.out.println(false);
    }
}
