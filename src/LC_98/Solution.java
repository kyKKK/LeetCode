package LC_98;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;

//  98 验证二叉搜索树
public class Solution {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }

    //  递归
    public boolean isValidBST(TreeNode root) {
        return help(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }


    public boolean help(TreeNode root, int lower, int upper) {
        if (null == root)
            return true;
        if (root.val > upper)
            return false;
        if (root.val < lower)
            return false;
        return help(root.left, lower, root.val) && help(root.right, root.val, upper);
    }

    //  迭代BFS
    LinkedList<TreeNode> nodeList = new LinkedList<>();
    LinkedList<Integer> lowerList = new LinkedList<>(), upperList = new LinkedList<>();

    public boolean isisValidBST_1(TreeNode root) {
        Integer lower = null, upper = null;
        TreeNode node = null;
        nodeList.add(root);
        lowerList.add(null);
        upperList.add(null);
        while (!nodeList.isEmpty()) {
            node = nodeList.poll();
            lower = lowerList.poll();
            upper = upperList.poll();
            if (node == null)
                continue;
            if (null != lower && node.val <= lower) {
                return false;
            }
            if (null != upper && node.val >= upper) {
                return false;
            }
            nodeList.add(node.left);
            lowerList.add(lower);
            upperList.add(node.val);
            nodeList.add(node.right);
            lowerList.add(node.val);
            upperList.add(upper);
        }
        return true;
    }

    //  迭代DFS
    public boolean isisValidBST_2(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        Integer min = -Integer.MAX_VALUE;
        boolean firstVisit = true;
        TreeNode node = root;
        while (!stack.isEmpty() || null != node) {
            while (null != node) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            if (node.val <= min && !firstVisit)
                return false;
            min = node.val;
            if (firstVisit)
                firstVisit = false;
            node = node.right;
        }
        return true;
    }
}
