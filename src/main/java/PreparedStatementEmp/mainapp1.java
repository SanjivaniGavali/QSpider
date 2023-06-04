package PreparedStatementEmp;

import java.util.Scanner;

public class mainapp1 {
    public static void main(String[] args) {
        salary1 s1=new salary1();
        Scanner sc=new Scanner(System.in);
        System.out.println("Select operation\n1:emp with max sal\n2:emp with min sal");
        int choice=sc.nextInt();
        if(choice==1){
            s1.maxSal();
        }else if(choice==2){
            s1.minSal();
        }
    }
}
