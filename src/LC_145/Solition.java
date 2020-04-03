package LC_145;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
//  二叉树的后序遍历
public class Solition {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }

    List<Integer> ret = new ArrayList<>();
    //  递归
    public List<Integer> postorderTraversal_recursive(TreeNode root) {
        if (null == root)
            return ret;
        postorderTraversal_recursive(root.left);
        postorderTraversal_recursive(root.right);
        ret.add(root.val);
        return ret;
    }
    //  迭代
    public List<Integer> postorderTraversal(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> results = new LinkedList<>();
        TreeNode node = root;
        while (!stack.isEmpty() || null != node) {
            if (null != node) {
                results.addFirst(node.val);
                stack.push(node);
                node = node.right;
            } else {
                node = stack.pop();
                node = node.left;
            }
        }
        return results;
    }
}
