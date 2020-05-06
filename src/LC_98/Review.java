package LC_98;

//  2020年4月20日
public class Review {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }

    public boolean isValidBST(TreeNode root) {
        return help(root, null, null);
    }

    public boolean help(TreeNode node, Integer min, Integer max) {
        if (node == null)
            return true;
        if (min != null && node.val <= min)
            return false;
        if (max != null && node.val >= max)
            return false;
        return help(node.left, min, node.val) && help(node.right, node.val, max);
    }
}
