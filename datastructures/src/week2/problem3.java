package week2;

import java.util.Scanner;

public class problem3 {
    static int rank[];
    static int tables[];
    static int max=-1;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        rank=new int[n];
        tables=new int[n];
        for (int i=0;i<n;i++){
            rank[i]=sc.nextInt();
            if (rank[i]>max)
                max=rank[i];
        }
        for (int i=0;i<n;i++)
            tables[i]=i;
        for (int i=0;i<m;i++){
            Merging_tables(sc.nextInt()-1,sc.nextInt()-1);
        }

    }

    private static void Merging_tables(int source, int dest) {
        int a1=find(source);
        int a2=find(dest);
        if (a1==a2){System.out.println(max);return;}
        if (rank[a1]>rank[a2]){
            tables[a2]=tables[a1];
            rank[a1]+=rank[a2];
            if (rank[a1]>max)
                max=rank[a1];
            System.out.println(max);
        }
        else if (rank[a1]<=rank[a2]){
            tables[a1]=tables[a2];
            rank[a2]+=rank[a1];
            if (rank[a2]>max)
                max=rank[a2];
            System.out.println(max);
        }

    }

    private static int find(int source) {
        if (source!=tables[source])
            tables[source]=find(tables[source]);
        return tables[source];
    }


}