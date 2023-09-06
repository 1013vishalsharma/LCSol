package SDESheet.BinaryTree_II;

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

public class DiameterOfBT {

    static int max = Integer.MIN_VALUE;
    public static int diameterOfBinaryTree(Node root) {
        int res = inOrder(root);
        System.out.println(res);
        System.out.println(max);
        return res;
    }

    private static int inOrder(Node root){
        if(root == null){
            return 0;
        }
        int lh = inOrder(root.left);
        int rh = inOrder(root.right);
        int maxRes = 1 + Math.max(lh, rh);
        int maxH = lh + rh;
        if(maxH > max){
            max = maxH;
        }
        return maxRes;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(2);
        root.left.left.left = new Node(2);
        root.left.right = new Node(2);
        root.left.right.right = new Node(2);
        root.left.right.right.left = new Node(2);
        root.left.right.right.right = new Node(2);
        root.left.right.right.right.left = new Node(2);
        root.left.left.right = new Node(2);
        root.left.left.right.left = new Node(2);
        root.left.left.right.left.right = new Node(2);
        root.right = new Node(2);

        diameterOfBinaryTree(root);
    }
}
