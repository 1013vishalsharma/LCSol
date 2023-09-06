package org.example;

public class Main {

    int i;
    String str;

    public Main(int i, String str){
        this.str = str;
        this.i = i;
    }

    public static void name(Main m1){
        Main m3 = m1;
        m3.i = 30;
    }

    public static void main(String[] args) {
        Main m1 = new Main(10, "hello");
        Main m2 = m1;

        m2.i = 20;

        System.out.println(m2.i);
        System.out.println(m1.i);
        name(m1);
        System.out.println(m1.i);

        System.out.println("Hello world!");
    }
}