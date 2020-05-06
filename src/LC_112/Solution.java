package LC_112;


//  122、路径总和
public class Solution {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;
        sum = sum - root.val;
        if (root.left == null && root.right == null)
            return sum == 0;
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }


}
