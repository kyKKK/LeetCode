package LC_34;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
//  2020年5月7日
public class Review {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    List<Integer> ret = new LinkedList<>();

    //  递归
    public List<Integer> inorderTraversal(TreeNode root) {
        help(root);
        return ret;
    }

    public void help(TreeNode root) {
        if (root == null)
            return;
        help(root.left);
        ret.add(root.val);
        help(root.right);
    }

    //  迭代
    public List<Integer> inorderTraversal_1(TreeNode root) {
        if (root == null)
            return null;
        Deque<TreeNode> stack = new LinkedList<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            ret.add(root.val);
            root = root.right;
        }
        return ret;
    }
}
