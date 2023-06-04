package Grooming;

import java.util.Scanner;

public class Substring {
    public static void main(String[] args) {
        String str="madam";
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter substring");
        String substr=sc.next();
        int n1=str.length();
        int n2=substr.length();
        char ch=substr.charAt(0);
        boolean isMissMatch=false;
        for(int i=0;i<n1-n2;i++){
            int currenti=i;
            if(ch==str.charAt(i)){

                for(int j=0;j<n2;j++){
                    if(str.charAt(i)!=substr.charAt(j)){
                        isMissMatch=true;
                    }
                    i++;
                }
            }
        }
        if(isMissMatch){
            System.out.println(false);
        }else {
            System.out.println(true);
        }


    }
}
