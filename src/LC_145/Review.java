package LC_145;

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

    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> ret = new LinkedList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                ret.addFirst(root.val);
                root = root.right;
            }
            root = stack.pop();
            root = root.left;
        }
        return ret;
    }
}
