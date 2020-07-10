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
        return helper(root, sum);
    }

    private boolean helper(TreeNode root, int sum) {
        if (root.left == null && root.right == null)
            return sum - root.val == 0;
        sum -= root.val;
        boolean leftHas = false, rightHas = false;
        if (root.left != null)
            leftHas = helper(root.left, sum);
        if (root.right != null)
            rightHas = helper(root.right, sum);
        return leftHas || rightHas;


    }


}
