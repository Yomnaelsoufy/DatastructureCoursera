package week2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class pairs{
    long a,b;
    pairs(long a,long b){
        this.a=a;
        this.b=b;
    }
}
public class problem2 {
    static long[] a;
    static long[] v;
    static long[]ind;
    static int size;
    static List<pairs> p=new ArrayList();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int tl=sc.nextInt();
        ind=new long[n];
        v=new long[n+1];
        a=new long[tl];
        for (int i=0;i<tl;i++)
            a[i]=sc.nextLong();
        for (int i=0;i<n;i++)
            ind[i]=(long)i;
        for (int i=0;i<v.length;i++)
            v[i]=0;
        Parallel_processing();


    }

    private static void Parallel_processing() {
        size=v.length-1;
        for (int i=0;i<a.length;i++){
            Extract_min(a[i]);
        }
        for (int i=0;i<p.size();i++){
            System.out.println(p.get(i).a+" "+p.get(i).b);
        }
    }

    private static void Extract_min(long i) {
        p.add(new pairs(ind[0],v[1]));

        v[1]+=i;

        siftDown(1);
    }

    private static void siftDown(int i) {
        int maxind=i;
        boolean le=false,ri=false;
        int r=rightChild(i);
        int l=leftChild(i);

        if (l<=size&&v[l]<=v[maxind])
        {   le=true;

        }
        if (r<=size&&v[r]<=v[maxind])
        {ri=true;
        }
        if (ri&&le) {
            if (v[r] == v[l]) {
                if (ind[l - 1] < ind[r - 1])
                    maxind = l;
                else maxind = r;
            }
            else if (v[r] < v[l])maxind = r;
            else maxind=l;
        }
        else if (ri)maxind=r;
        else if (le)maxind=l;
        if (i!=maxind){
            swap(i,maxind,v);
            swap(i-1,maxind-1, ind);
            siftDown(maxind);
        }
    }

    private static void swap(int i, int maxind, long[] arr) {
        long temp=arr[i];
        arr[i]=arr[maxind];
        arr[maxind]=temp;
    }

    private static int rightChild(int i) {
        return 2*i+1;
    }

    private static int leftChild(int i) {
        return 2*i;
    }}