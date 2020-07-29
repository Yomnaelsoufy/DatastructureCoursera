package week3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class problem2 {
    static int m,ind=0;
    static int prime=1000000007,x=263;
    static List[]tables;
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        m=sc.nextInt();
        tables=new List[m];
        for (int i=0;i<m;i++)
            tables[i]=new ArrayList<String>();
        int N=sc.nextInt();
        for (int i=0;i<N;i++)
            Hashing_with_chains(sc.next());
    }

    private static void Hashing_with_chains(String str) {

        if (str.equals("add")){
            Add(sc.next());
        }
        else if (str.equals("check")){
            Check(sc.nextInt());
        }
        else if (str.equals("find")){
            boolean b=  Find(sc.next());
            if (b)
                System.out.println("yes");
            else  System.out.println("no");
        }
        else if (str.equals("del")){
            Deletion(sc.next());
        }
    }
    private static void Deletion(String str){
        List<String>l=tables[PolyHashing(str)];
        for (int i=0;i<l.size();i++){
            if (l.get(i).equals(str)){
                l.remove(i);
                return;
            }
        }}
    private static boolean Find(String str){
        ind=PolyHashing(str);
        List<String>l=tables[ind];
        for (int i=0;i<l.size();i++){
            if (l.get(i).equals(str)){

                return true;
            }
        }
        return false;
    }
    private static void Check(int nextInt) {
        boolean b=false;
        for (int i=0;i<tables[nextInt].size();i++){b=true;
            System.out.print(tables[nextInt].get(i)+" ");
        }
        System.out.println();
    }

    private static void Add(String next) {
        if (!Find(next))
            tables[ind].add(0,next);
    }

    static int PolyHashing(String s){
        Long hash=(long)0;
        for (int i=s.length()-1;i>=0;i--){
            hash=(hash*x+(int)s.charAt(i));
            hash=((hash%prime) + prime)%prime;
        }
        return (int) ((hash)%m);
    }
}
