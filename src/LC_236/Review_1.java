package LC_236;

public class Review_1 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    TreeNode ans = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;
        dfs(root, p, q);
        return ans;
    }

    public boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        boolean leftExist = dfs(root.left, p, q);
        boolean rightExist = dfs(root.right, p, q);
        if (leftExist && rightExist || (root.val == p.val || root.val == q.val) && (leftExist || rightExist))
            ans = root;
        return leftExist || rightExist || root.val == p.val || root.val == q.val;
    }
}
