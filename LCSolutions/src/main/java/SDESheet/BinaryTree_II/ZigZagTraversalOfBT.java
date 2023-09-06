package SDESheet.BinaryTree_II;

import java.util.*;

public class ZigZagTraversalOfBT {

    public static List<List<Integer>> zigzagLevelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null)
            return res;
        boolean flip = true;
        Deque<Node> qu = new LinkedList<>();
        qu.add(root);

        while(!qu.isEmpty()){
            int size = qu.size();
            List<Integer> li = new ArrayList<>();
            while(size > 0){
                Node n = null;

                if (!flip){
                    n = qu.removeLast();
                    if(n.right != null){
                        qu.addFirst(n.right);
                    }
                    if(n.left != null){
                        qu.addFirst(n.left);
                    }
                } else {
                    n = qu.removeFirst();
                    if(n.left != null){
                        qu.addLast(n.left);
                    }
                    if(n.right != null){
                        qu.addLast(n.right);
                    }
                }
                li.add(n.val);
                size--;
            }
            flip = !flip;
            res.add(li);
        }

        return res;
    }

    public static void main(String[] args) {

        /*Node root = new Node(3);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);
        //root.left = new Node();*/

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.right = new Node(5);
        //root.left = new Node();

        zigzagLevelOrder(root);
    }
}
