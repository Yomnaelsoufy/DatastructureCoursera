package week2;

import java.util.*;


public class problem1 {
    static int[] a;
    static int size;
    static List<pairs> p=new ArrayList();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        a=new int[n+1];
        for (int i=1;i<n+1;i++)
            a[i]=sc.nextInt();
        Buildheap();


    }

    private static void Buildheap() {
        size=a.length-1;
        for (int i=size/2;i>=1;i--){
            siftDown(i);
        }
        System.out.println(p.size());
        for (int i=0;i<p.size();i++){
            System.out.println(p.get(i).a+" "+p.get(i).b);
        }
    }

    private static void siftDown(int i) {
        int maxind=i;
        int l=leftChild(i);
        if (l<=size&&a[l]<a[maxind])
        {
            maxind=l;
        }
        int r=rightChild(i);
        if (r<=size&&a[r]<a[maxind])
        {
            maxind=r;
        }
        if (i!=maxind){
            swap(i,maxind);
            p.add(new pairs(i-1,maxind-1));
            siftDown(maxind);
        }
    }

    private static void swap(int i, int maxind) {
        int temp=a[i];
        a[i]=a[maxind];
        a[maxind]=temp;
    }

    private static int rightChild(int i) {
        return 2*i+1;
    }

    private static int leftChild(int i) {
        return 2*i;
    }

}