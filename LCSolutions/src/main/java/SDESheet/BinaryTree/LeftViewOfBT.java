package SDESheet.BinaryTree;

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

public class LeftViewOfBT {

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);

        Queue<Node> qu = new LinkedList<>();
        qu.add(root);

        System.out.println("Left view:");

        while(!qu.isEmpty()){
            int size = qu.size();
            System.out.println(qu.peek().val);
            while(size > 0){
                Node node = qu.poll();

                if(node.left != null){
                    qu.add(node.left);
                }

                if(node.right != null){
                    qu.add(node.right);
                }
                size--;
            }
        }

        qu.add(root);

        System.out.println("Right view:");

        while(!qu.isEmpty()){
            int size = qu.size();
            System.out.println(qu.peek().val);
            while(size > 0){
                Node node = qu.poll();

                if(node.right != null){
                    qu.add(node.right);
                }

                if(node.left != null){
                    qu.add(node.left);
                }
                size--;
            }
        }
    }
}
