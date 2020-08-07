package LC_105;

import java.util.HashMap;
import java.util.Map;

class TreeNode {
    private int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        this.val = x;
    }
}

public class Solution {
    Map<Integer, Integer> map = new HashMap<>();

    private void addMap(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        addMap(preorder, inorder);
        return buildTree_recur(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode buildTree_recur(int[] preorder, int[] inorder, int pre_left, int pre_right, int in_left, int in_right) {
        if (pre_left > pre_right)
            return null;
        int inorder_root_index = map.get(preorder[pre_left]);
        int left_size = inorder_root_index - in_left;
        TreeNode root = new TreeNode(preorder[pre_left]);
        root.left = buildTree_recur(preorder, inorder, pre_left + 1, pre_left + left_size, in_left, inorder_root_index - 1);
        root.right = buildTree_recur(preorder, inorder, pre_left + left_size + 1, pre_right, inorder_root_index + 1, in_right);
        return root;
    }
}
