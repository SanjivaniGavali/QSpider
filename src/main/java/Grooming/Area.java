package Grooming;

public class Area {
    public static void main(String[] args) {
       areaOfShape();
       shape1(10,8);
       shape2(5,12);
    }
   static void areaOfShape(){
        double area1=10*8;
        double area2=(1/2)*12*5;
        double total=area1+area2;
        System.out.println("Area="+total);
    }
    static void shape1(int l,int w){
        double areashape1=l*w;
        System.out.println(areashape1);
    }
    static  void shape2(int h,int w){
        double areashape2=(1/2)*h*w;
        System.out.println(areashape2);
    }


}
