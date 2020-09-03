package jianzhiOffer.J_68_II;

public class Solution {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private TreeNode ret = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        helper(root, p, q);
        return ret;
    }

    private boolean helper(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null)
            return false;
        boolean left_exist = helper(node.left, p, q);
        boolean right_exist = helper(node.right, p, q);
        if (left_exist && right_exist || (node.val == p.val || node.val == q.val) && (left_exist || right_exist))
            ret = node;

        return node.val == p.val || node.val == q.val || left_exist || right_exist;
    }
}
