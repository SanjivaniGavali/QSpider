package Grooming;

public class SecondMax1 {
    public static void main(String[] args) {
        int[] arr={-10,-20,-30,-40,-50};
        int n= arr.length;
        int maxi1=Integer.MIN_VALUE;
        int maxi2=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(arr[i]>maxi1){
                maxi1=arr[i];
            }
        }
        for(int i=0;i<n;i++){
            if(arr[i]>maxi2 && arr[i]!=maxi1){
                maxi2=arr[i];
            }
        }
        System.out.println(maxi2);


    }
}
