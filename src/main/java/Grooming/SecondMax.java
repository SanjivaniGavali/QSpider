package Grooming;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class SecondMax {
    public static void main(String[] args) {
        int[] arr={20,47,90,12,78,65,10};
        int n= arr.length;
        //Priority Queue or treeSet or treemap
        Queue<Integer> data=new PriorityQueue<>(Comparator.reverseOrder());
        for(int i=0;i<n;i++){
            data.offer(arr[i]);
        }
        data.poll();
        System.out.println("Second Max:"+data.peek());

    }
}
