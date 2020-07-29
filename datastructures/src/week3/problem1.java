package week3;

import java.util.Scanner;

public class problem1 {
    static String bookphone[];
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        bookphone=new String[10000000];
        int N=sc.nextInt();
        for (int i=0;i<N;i++)
            PhoneBook(sc.next());
    }

    private static void PhoneBook(String str) {

        if (str.equals("add")){
            Add(sc.nextInt(),sc.next());
        }
        else if (str.equals("find")){
            String f=Find(sc.nextInt());
            if (f==null)
                System.out.println("not found");
            else System.out.println(f);
        }
        else if (str.equals("del")){
            Del(sc.nextInt());
        }

    }

    private static void Del(int parseInt) {
        bookphone[parseInt]=null;

    }

    private static String Find(int parseInt) {
        return bookphone[parseInt];
    }

    private static void Add(int parseInt, String s) {
        bookphone[parseInt]=s;
    }
}