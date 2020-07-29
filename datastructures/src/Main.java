
import javax.naming.directory.SearchControls;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Main {
    static Answer ans =new Answer();
    static long[] arr1;
    static long[] arr2;
    static HashMap m1=new HashMap();
    static HashMap m2=new HashMap();
    private static int prime1 = 1000000007;
    private static int prime2 = 1000000009;
    private static int x1 ;
    private static int x2 ;

    public static class Answer {
        int i, j, len;
        Answer(){}
        Answer(int i, int j, int len) {
            this.i = i;
            this.j = j;
            this.len = len;
        }
    }





    private static void SearchLCS(String s, String t) {
        int l=0;
        int r=Integer.min(s.length(),t.length());
        int k;
        while (l<=r){
            k=(l+r)/2;
            if (isLCS(s,t,k)){
                l=k+1;
            }
            else r=k-1;
        }

    }
    static long power(long x, long y,long p)
    {
        if (y == 0)
            return 1;

        if (y == 1)
            return x% p;

        long t = power(x, y / 2,p);
        t = (t * t) % p;

        // if exponent is even value
        if (y % 2 == 0)
            return t;

            // if exponent is odd value
        else
            return ((x% p) * t) % p;
    }

    private static boolean isLCS(String s, String t, int k) {
       m1=new HashMap<Integer,Long>();
       m2=new HashMap<Integer,Long>();
       boolean nb=false;
       if (t.length()>s.length()){
           String tem=t;
           t=s;
           s=tem;
           nb=true;
       }
       arr1=new long[t.length()+1];
       arr2=new long[t.length()+1];
        x1=(int)(Math.random()*(prime1))+1;
        x2=(int)(Math.random()*(prime2))+1;
        String temp=s.substring(s.length()-k);
        m1.put(s.length()-k,PolyHashing(temp,x1,prime1));
        long y=power(x1,k,prime1);

        for (int i=s.length()-k-1;i>=0;i--){
            Object o=(((x1*(Long) m1.get(i+1)+(s.charAt(i)-y*s.charAt(i+k)))%prime1)+prime1)%prime1;
            m1.put(i,o);
        }
        String temp1=t.substring(t.length()-k);
        arr1[t.length()-k]=(long)PolyHashing(temp1,x1,prime1);
        for (int i=t.length()-k-1;i>=0;i--){
            arr1[i]=((((x1*arr1[i+1]+(t.charAt(i)-y*t.charAt(i+k)))%prime1)+prime1)%prime1);
        }
        String tempp=s.substring(s.length()-k);
        m2.put(s.length()-k,PolyHashing(tempp,x2,prime2));
         y=power(x2,k,prime2);

        for (int i=s.length()-k-1;i>=0;i--){
            m2.put(i,(((x2*(long)m2.get(i+1)+(s.charAt(i)-y*s.charAt(i+k)))%prime2)+prime2)%prime2);
        }
        String temp11=t.substring(t.length()-k);
        arr1[t.length()-k]=(long)PolyHashing(temp11,x2,prime2);
        for (int i=t.length()-k-1;i>=0;i--){
            arr1[i]=((((x2*arr1[i+1]+(t.charAt(i)-y*t.charAt(i+k)))%prime2)+prime2)%prime2);
        }
        for (int i=0;i<arr1.length;i++){
            if (m1.containsValue(arr1[i])&&m2.containsValue(arr2[i])){
                if (nb){
                    ans.i=(int)getKey(m1,arr1[i]);
                    ans.j=i;
                    ans.len=k;
                }
                else {
                    ans.j=(int)getKey(m1,arr1[i]);
                    ans.i=i;
                    ans.len=k;
                }return true;
            }
        }
        return false;
    }
    public static <K, V> K getKey(Map<K, V> map, V value) {
        for (K key : map.keySet()) {
            if (value.equals(map.get(key))) {
                return key;
            }
        }
        return null;
    }
    static int PolyHashing(String s,int x,int prime){
        long hash=(long)0;
        for (int i=s.length()-1;i>=0;i--){
            hash=(hash*x+(int)s.charAt(i));
        }
        return (int)((hash%prime) + prime)%prime;
    }
    static public void main(String[] args) {
       Scanner sc=new Scanner(System.in);
       String s=sc.next();
    String t=sc.next();
    SearchLCS(s,t);
    System.out.println(ans.i+" "+ans.j+" "+ans.len);
    }
}