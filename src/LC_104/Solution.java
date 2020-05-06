package LC_104;

import LC_226.Solition;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }

    //  递归一
    public int maxDepth(TreeNode root) {
        if (null == root)
            return 0;
        return help(root, 0);
    }

    public int help(TreeNode root, int depth) {
        if (null == root.left && null == root.right)
            return depth;
        int left = 0, right = 0;
        if (null != root.left) {
            left = help(root.left, depth + 1);
        }
        if (null != root.right) {
            right = help(root.right, depth + 1);
        }
        return Math.max(left, right);
    }

    //  递归二
    public int maxDepth_1(TreeNode root) {
        if (null == root) {
            return 0;
        } else {
            int left_hight = maxDepth_1(root.left);
            int right_hight = maxDepth_1(root.right);
            return Math.max(left_hight, right_hight) + 1;
        }
    }

    //  迭代
    public int maxDepth_2(TreeNode root) {
        if (null == root)
            return 0;
        LinkedList<TreeNode> list = new LinkedList();
        int maxDepth = 0;
        list.add(root);
        while (!list.isEmpty()) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = list.removeFirst();
                if (null != node.left)
                    list.add(node.left);
                if (null != node.right)
                    list.add(node.right);
            }
            maxDepth++;
        }
        return maxDepth;
    }
}
