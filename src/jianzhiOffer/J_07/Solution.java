package jianzhiOffer.J_07;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    Map<Integer, Integer> inorder_seq = new HashMap<>();
    int[] pre;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            inorder_seq.put(inorder[i], i);
        }
        pre = preorder;
        return helper(0, 0, pre.length - 1);
    }

    private TreeNode helper(int root_index, int left, int right) {
        if (left > right)
            return null;
        int i = inorder_seq.get(pre[root_index]);
        TreeNode root = new TreeNode(pre[root_index]);
        root.left = helper(root_index + 1, left, i - 1);
        root.right = helper(root_index + i - left + 1, i + 1, right);
        return root;
    }
}
