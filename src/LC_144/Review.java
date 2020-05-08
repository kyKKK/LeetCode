package LC_144;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Review {
    class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ret = new LinkedList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                ret.add(root.val);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
        return ret;
    }
}
