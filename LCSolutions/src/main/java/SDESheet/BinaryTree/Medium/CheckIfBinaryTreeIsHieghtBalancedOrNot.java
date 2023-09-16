package main.java.SDESheet.BinaryTree.Medium;

public class CheckIfBinaryTreeIsHieghtBalancedOrNot {

    public static boolean isBalance = true;
    public boolean isBalanced(TreeNode root) {
        isBalance = true;
        if (root == null){
            return true;
        }

        height(root);
        System.out.println(isBalance);
        return isBalance;
    }

    private int height(TreeNode root){
        if(root == null){
            return 0;
        }

        int lh = height(root.left);
        int rh = height(root.right);

        if (Math.abs(lh - rh) > 1){
            isBalance = false;
        }

        return 1 + Math.max(lh, rh);
    }

    public static void main(String[] args) {
        CheckIfBinaryTreeIsHieghtBalancedOrNot sol = new CheckIfBinaryTreeIsHieghtBalancedOrNot();
        /*TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(90);*/

        TreeNode root = null;

        System.out.println(sol.isBalanced(root));
    }
}
