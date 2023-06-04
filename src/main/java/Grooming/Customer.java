package Grooming;

public class Customer {
    int cid;
    String name;
    int age;
    public Customer(int cid,String name,int age) {
        this.cid=cid;
        this.name=name;
        this.age=age;
    }

    @Override
    public String toString() {
        return "Customer{"+"cID="+cid+",cNAME="+name+",age="+age+"}";
    }
}
