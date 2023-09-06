/*
package SDESheet.BinaryTree;

import java.util.*;

class Ele {
    Node node;
    int degree;

    public Ele(Node node, int degree){
        this.node = node;
        this.degree = degree;
    }
}
public class BottomViewOfBT {

    public static void bottomViewOfBT(Node root) {
        if(root == null){
            System.out.println("-");
        }

        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Ele> qu = new LinkedList<>();
        qu.add(new Ele(root, 0));
        map.put(0, root.val);

        while(!qu.isEmpty()){
            Ele ele = qu.poll();
            Node curr = ele.node;
            int degree = ele.degree;

            if(curr.left != null){
                int currDegree = degree - 1;
                qu.add(new Ele(curr.left, currDegree));
                map.put(currDegree, curr.left.val);
            }

            if(curr.right != null){
                int currDegree = degree + 1;
                qu.add(new Ele(curr.right, currDegree));
                map.put(currDegree, curr.right.val);
            }
        }

        map.values().forEach(x -> System.out.print(x + ", "));

    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(60);

        bottomViewOfBT(root);
    }
}
*/
