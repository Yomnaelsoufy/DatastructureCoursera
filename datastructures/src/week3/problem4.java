package week3;
import java.util.Scanner;

public class problem4 {
    static long []H1;
    static long []H2;
    private static int prime1 = 1000000007;
    private static int prime2 = 1000000009;
    private static int x1 = (int)(Math.random()*(prime1))+1;
    private static int x2 = (int)(Math.random()*(prime2))+1;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        int n=sc.nextInt();
        precomputeHashes(s);
        for (int i=0;i<n;i++){
            int a=sc.nextInt();
            int b=sc.nextInt();
            int l=sc.nextInt();
            Substring_equality(a,b,l);
        }
    }

    private static void Substring_equality(int a, int b, int l) {
        long pow1=power(x1,l,prime1);
        long pow2=power(x2,l,prime2);
        long a1=(((H1[a+l]-pow1*H1[a])%prime1)+prime1)%prime1;
        long b1=(((H1[b+l]-pow1*H1[b])%prime1)+prime1)%prime1;
        long a2=(((H2[a+l]-pow2*H2[a])%prime2)+prime2)%prime2;
        long b2=(((H2[b+l]-pow2*H2[b])%prime2)+prime2)%prime2;
        if (a1==b1&&a2==b2)
            System.out.println("Yes");
        else System.out.println("No" );
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

    private static void precomputeHashes(String s) {
        H1 =new long[s.length()+1];
        H2 =new long[s.length()+1];
        H1[0]=H2[0] = 0;
        for(int i=1;i<=s.length();i++){
            H1[i]=(((H1[i-1]*x1+s.charAt(i-1))%prime1)+prime1)%prime1;
            H2[i]=(((H2[i-1]*x2+s.charAt(i-1))%prime2)+prime2)%prime2;

        }

    }}