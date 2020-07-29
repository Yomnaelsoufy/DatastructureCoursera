package week1;

import java.util.*;

public class problem3 {static List<Integer> starter=new ArrayList<>();
    static  List<Integer>ender=new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s=sc.nextInt();
        int n = sc.nextInt();
        for (int i=0;i<n;i++){
            starter.add(sc.nextInt());
            ender.add(sc.nextInt());
        }
        Network_packet_processing_simulation(s);

    }

    private static void Network_packet_processing_simulation(int s) {
        if (starter.size()==0)return;
        Queue<Integer> start=new LinkedList<>();
        Queue<Integer>end=new LinkedList<>();
        int ts=s-1,t=starter.get(0);
        start.add(t);
        t+=ender.get(0);
        end.add(t);
        for (int i=1;i<starter.size();i++){
            if (ts>0){
                if (t<starter.get(i)){t=starter.get(i);start.add(t);}
                else start.add(t);
                t+=ender.get(i);
                end.add(t);
                ts-=1;
            }
            else if (end.peek()<=starter.get(i)){
                int tem=start.peek();
                System.out.println(tem);
                end.poll();
                if (t<starter.get(i)){t=starter.get(i);start.add(t);}
                else start.add(t);
                t+=ender.get(i);
                start.poll();
                end.add(t);
            }
            else start.add(-1);
        }
        while (!start.isEmpty()) System.out.println(start.poll());
    }

}
