package org.example;

import java.util.LinkedList;
import java.util.Queue;

class Node {
    int val;
    Node left;
    Node right;

    public Node(int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class NetCracker {
    /*
           o
	      / \
	     o---o
	    / \ / \
	   o---o---o
	  / \ / \ / \
	 o---o---o---o


     */

    public static void main(String[] args) {

        int j= 0, n = 4;
        while(n != 0) {
            for (int i = 0; i < n; i++) {
                System.out.print("o");
                if (j != n - 1 + i) {
                    System.out.print("---");
                    j++;
                }
            }
            System.out.println();
            n--;
        }
    }
}
