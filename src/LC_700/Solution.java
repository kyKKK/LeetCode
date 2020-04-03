package LC_700;

public class Solution {
    class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        TreeNode(int x) {
            this.val = x;
        }
    }

    //  迭代
    public TreeNode searchBST(TreeNode root, int val) {
        if (root.val == val) {
            return root;
        }
        TreeNode node = root;
        while (node != null && val != node.val) {
            if (val < node.val) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return node;
    }

    //  递归
    public TreeNode searchBST_recursive(TreeNode root, int val) {
        TreeNode node;
        if (null == root || val == root.val)
            return root;
        if (val < root.val)
            node = searchBST_recursive(root.left, val);
        else
            node = searchBST_recursive(root.right, val);
        return node;
    }
}
