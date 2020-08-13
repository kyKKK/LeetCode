package LC_105;

import java.util.HashMap;
import java.util.Map;

public class Review810 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private Map<Integer, Integer> map;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0)
            return null;
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return internal(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode internal(int[] preorder, int[] inorder, int pre_left, int pre_right, int in_left, int in_right) {
        if (in_left > in_right)
            return null;
        if (in_left == in_right)
            return new TreeNode(inorder[in_left]);
        int root_pos = map.get(preorder[pre_left]);
        TreeNode root = new TreeNode(inorder[root_pos]);
        root.left = internal(preorder, inorder, pre_left + 1, pre_left + root_pos - in_left, in_left, root_pos - 1);
        root.right = internal(preorder, inorder, pre_left + root_pos - in_left + 1, pre_right, root_pos + 1, in_right);
        return root;
    }
}
