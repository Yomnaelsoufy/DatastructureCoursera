package week1;
import java.util.*;
class Node{
    int val,lvl;
    List<Node>child=new ArrayList<>();
    Node(int val){
        this.val=val;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public int getLvl() {
        return lvl;
    }

    void setChild(Node node){
        child.add(node);
    }
}

public class problem2 {
    static Node root;
    static Node node[];
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        node=new Node[n];
        for (int i=0;i<n;i++)
        {int parent=sc.nextInt();
            if (node[i]==null)node[i]=new Node(i);
            if (parent==-1)
                root=node[i];
            else{
                if (node[parent]==null)node[parent]=new Node(parent);
                node[parent].setChild(node[i]);}
        }
        int l=1;
        System.out.println(Tree_height());
    }

    private static int Treeheight(Node n, int l) {
        if (n.child.size()==0) return l;
        int h=0;
        for (int i=0;i<n.child.size();i++){
            h=Integer.max(h,Treeheight(n.child.get(i),l+1));
        }
        return h;
    }
    private static int Tree_height(){
        if (root==null)return 0;
        Queue<Node> q=new LinkedList<>();
        int max =-1;
        q.add(root);
        root.setLvl(1);
        while (!q.isEmpty()){
            Node node=q.poll();
            for (int i=0;i<node.child.size();i++){
                q.add(node.child.get(i));
                node.child.get(i).setLvl(node.lvl+1);
                max=Integer.max(max,node.lvl+1);
            }
        }
        return max;
    }
}
