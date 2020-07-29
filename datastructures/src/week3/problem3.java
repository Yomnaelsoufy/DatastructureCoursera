package week3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class problem3 {
    static int ind=0;
    static int prime=1000000007,x=1;
    static List[]tables;
    static int [] h;
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        String P=sc.next();
        String S=sc.next();
        List<Integer>l= ImprovedRabinKarp (S,P);
        for (int i=0;i<l.size();i++)
            System.out.print(l.get(i)+" ");
    }
    static List <Integer>ImprovedRabinKarp(String S,String P){
        List<Integer>r=new ArrayList<>();
        int phash=PolyHashing(P);
        h=Precomputehashes(S,P.length());
        for (int i=0;i<S.length()-P.length()+1;i++){
            if (phash!=h[i])
                continue;
            if (AreEqual(S.substring(i,i+P.length()),P))
                r.add(i);
        }
        return r;
    }
    static boolean AreEqual(String S,String P){
        if (S.length()!=P.length())return false;
        for (int i=0;i<S.length();i++){
            if (S.charAt(i)!=P.charAt(i))return false;
        }
        return true;
    }
    static int [] Precomputehashes(String S,int Psize){
        h=new int[S.length()-Psize+1];
        String temp=S.substring(S.length()-Psize);
        h[S.length()-Psize]=PolyHashing(temp);
        long y=1;
        for (int i=1;i<Psize+1;i++)
        {y=y*x;
            y=  ((y%prime) + prime)%prime;
        }
        for (int i=S.length()-Psize-1;i>=0;i--){
            h[i]=(int)(x*h[i+1]+(S.charAt(i)-y*S.charAt(i+Psize)));
            h[i]=(((h[i]%prime) + prime)%prime);
        }
        return h;
    }
    static int PolyHashing(String s){
        long hash=(long)0;
        for (int i=s.length()-1;i>=0;i--){
            hash=(hash*x+(int)s.charAt(i));
        }
        return (int)((hash%prime) + prime)%prime;
    }
}