package LC_98;

import java.util.LinkedList;
import java.util.List;

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

    public boolean isValidBST_1(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        double minVal = -Double.MAX_VALUE;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.val <= minVal)
                return false;
            minVal = root.val;
            root = root.right;
        }
        return true;
    }
}
