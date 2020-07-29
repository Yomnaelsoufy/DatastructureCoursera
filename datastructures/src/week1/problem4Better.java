package week1;

import java.util.*;

public class problem4Better {    static int[]a;
    static Scanner sc = new Scanner(System.in);
    static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    static List<Integer> stack=new ArrayList<>();
    public static void main(String[] args) {
        int n = sc.nextInt();
        String str="Pusj";
        for (int i=0;i<n;i++){
            str=sc.next();
            if (str.equals("push")){
                stack.add(sc.nextInt());
                maxHeap.add(stack.get(stack.size()-1));
            }
            else if (str.equals("pop"))
            {
                int sv=stack.get(stack.size()-1);
                stack.remove(stack.size()-1);
                maxHeap.remove(sv);
            }
            else {
                System.out.println(maxHeap.peek());
            }
        }
    }


}
