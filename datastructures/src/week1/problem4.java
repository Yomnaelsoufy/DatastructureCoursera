package week1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class problem4 {

    static int max=Integer.MIN_VALUE;
    static int maxind=0;
    static List<Integer> stack=new ArrayList<>();
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    String str="Pusj";
         for (int i=0;i<n;i++){
        str=sc.next();
        if (str.equals("push")){
            stack.add(sc.nextInt());
        }
        else
            Stack_operations(str);
    }
}

    private static void Stack_operations(String str) {
        if (str.equals("pop")){
            stack.remove(stack.size()-1);
            if (maxind==stack.size()){max=Integer.MIN_VALUE;maxind=0;}
            if (maxind>0)maxind--;
        }
        else {
            for (int i=maxind;i<stack.size();i++){
                if (max<=stack.get(i))
                { max=stack.get(i);
                    maxind=i;
                }
            }
            System.out.println(max);
        }
    }

}
