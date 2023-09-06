package SDESheet.BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class RootToNodePath {

    public static List<String> binaryTreePaths(Node root) {
        List<String> res = new ArrayList<>();
        preOrder(root, res, "");
        System.out.println(res);
        return res;
    }

    private static void preOrder(Node root, List<String> res, String ans) {
        if(root.left == null && root.right == null){
            ans += root.val;
            res.add(ans);
            return;
        }
        ans += root.val;
        if(root.left != null)
            preOrder(root.left, res, ans);
        if(root.right != null)
            preOrder(root.right, res, ans);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(5);

        binaryTreePaths(root);
    }
}
