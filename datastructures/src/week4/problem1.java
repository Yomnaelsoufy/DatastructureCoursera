package week4;

import java.util.*;

class Node{
    int k;
    Node l,r;
    Node (int k, Node l, Node r)
    {
        this.k=k;
        this.l=l;
        this.r=r;
    }
    Node(int k){
        this.k=k;
    }

    public void setL(Node l) {
        this.l = l;
    }

    public void setK(int k) {
        this.k = k;
    }

    public void setR(Node r) {
        this.r = r;
    }

    public int getK() {
        return k;
    }

    public Node getL() {
        return l;
    }

    public Node getR() {
        return r;
    }
}
public class problem1 {
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
        BuildTree();
        Inorder(root);
        System.out.println();
        preorder(root);
        System.out.println();
        postorder(root);
    }

    private static void postorder(Node n) {
        Stack<Node> s1 = new Stack<>();
        Stack<Node>s2 = new Stack<>();

        if (n== null)
            return;
        s1.push(n);

        while (!s1.isEmpty()) {
            Node temp = s1.pop();
            s2.push(temp);

            if (temp.getL()!= null)
                s1.push(temp.getL());
            if (temp.getR() != null)
                s1.push(temp.getR());
        }

        while (!s2.isEmpty()) {
            Node temp = s2.pop();
            System.out.print(temp.k + " ");
        }
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

    }
    static void preorder(Node n){
        if (n == null) {
            return;
        }
        Stack<Node> nodeStack = new Stack<Node>();
        nodeStack.push(n);
        while (nodeStack.empty() == false) {
            Node mynode = nodeStack.peek();
            System.out.print(mynode.k + " ");
            nodeStack.pop();
            if (mynode.getR() != null) {
                nodeStack.push(mynode.getR());
            }
            if (mynode.getL() != null) {
                nodeStack.push(mynode.getL());
            }
        }
    }
    static void Inorder(Node n){
        if (n == null)
            return;


        Stack<Node> s = new Stack<Node>();
        Node curr = n;
        while (curr != null || s.size() > 0)
        {

            while (curr !=  null){
                s.push(curr);
                curr = curr.getL();
            }

            curr = s.pop();

            System.out.print(curr.k + " ");

            curr = curr.getR();
        }
    }

}
