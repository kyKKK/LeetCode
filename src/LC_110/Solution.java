package LC_110;

public class Solution {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //  法一：自顶向下，有重复
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        return Math.abs(helper(root.left) - helper(root.right)) < 2 && (isBalanced(root.left) && isBalanced(root.right));

    }

    private int helper(TreeNode node) {
        if (node == null)
            return 0;
        int left = 1 + helper(node.left);
        int right = 1 + helper(node.right);
        return Math.max(left, right);
    }

    //  法二：自底向上
    private boolean ret = true;

    public boolean isBalanced_2(TreeNode root) {
        helper_2(root);
        return ret;
    }

    private int helper_2(TreeNode node) {
        if (node == null)
            return 0;
        int left = 1 + helper_2(node.left);
        int right = 1 + helper_2(node.right);
        if (Math.abs(left - right) > 2)
            ret = false;
        return Math.max(left, right);
    }
}
