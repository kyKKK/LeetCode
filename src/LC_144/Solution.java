package LC_144;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
//  二叉树的前序遍历
public class Solution {
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
    public List<Integer> preorderTraversal_recursive(TreeNode root) {
        if (null == root) {
            return ret;
        }
        ret.add(root.val);
        preorderTraversal_recursive(root.left);
        preorderTraversal_recursive(root.right);
        return ret;
    }

    //  迭代
    public List<Integer> preorderTraversal(TreeNode root) {
        if (null == root) {
            return ret;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            ret.add(node.val);
            if (null != node.right) {
                stack.push(node.right);
            }
            if (null != node.left) {
                stack.push(node.left);
            }
        }
        return ret;
    }

    //  迭代2
    public List<Integer> preorderTraversal_1(TreeNode root) {
        if (null == root)
            return ret;
        TreeNode node = root;
        Deque<TreeNode> stack = new LinkedList<>();
        while (null != node || !stack.isEmpty()) {
            if (null != node) {
                ret.add(node.val);
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                node = node.right;
            }
        }
        return ret;
    }
}
