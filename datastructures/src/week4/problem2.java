package week4;

import java.util.*;

public class problem2 {
    static Node root;
    static List<Integer> k=new ArrayList<>(),l=new ArrayList<>(),r=new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int n=sc.nextInt();
        for (int i=0;i<n;i++){
            k.add(sc.nextInt());
            l.add(sc.nextInt());
            r.add(sc.nextInt());
        }
        if (n==0)    System.out.println( "CORRECT");
        else {
            BuildTree();
            checkBST(root);
        }
    }

    private static void checkBST(Node n) {
        if (n == null)
            return;
        List<Integer>list=new ArrayList<>();
        Stack<Node> s = new Stack<Node>();
        Node curr = n;
        while (curr != null || s.size() > 0)
        {

            while (curr !=  null){
                s.push(curr);
                curr = curr.getL();
            }

            curr = s.pop();

            list.add(curr.k);

            curr = curr.getR();
        }
        for (int i=1;i<list.size();i++){
            if (list.get(i-1)>list.get(i)){
                System.out.println( "INCORRECT");
                return;
            }
        }
        System.out.println( "CORRECT");
    }


    private static void BuildTree() {
        root=new Node(k.get(0));
        Queue<Node> q=new LinkedList<>();
        Queue<Integer>ind=new LinkedList<>();
        if (l.get(0)!=-1){
            root.setL(new Node(k.get(l.get(0))));
            q.add(root.getL());
            ind.add(l.get(0));
        }
        if (r.get(0)!=-1){
            root.setR(new Node(k.get(r.get(0))));
            q.add(root.getR());
            ind.add(r.get(0));
        }
        while (!q.isEmpty()){
            Node n=q.poll();
            int i=ind.poll();
            if (l.get(i)!=-1){
                n.setL(new Node(k.get(l.get(i))));
                ind.add(l.get(i));
                q.add(n.getL());}
            if (r.get(i)!=-1){
                n.setR(new Node(k.get(r.get(i))));
                ind.add(r.get(i));
                q.add(n.getR());}

        }

    }}