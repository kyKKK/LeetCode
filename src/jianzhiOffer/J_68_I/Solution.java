package jianzhiOffer.J_68_I;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (root.val < q.val && root.val < p.val)
                root = root.right;
            else if (root.val > q.val && root.val > p.val)
                root = root.left;
            else
                break;
        }
        return root;
    }
}
