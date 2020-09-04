package LC_257;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private List<String> ret;
    private LinkedList<Integer> list = new LinkedList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        ret = new LinkedList<>();
        helper(root);
        return ret;
    }

    private void helper(TreeNode root) {
        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            StringBuilder sb = new StringBuilder();
            for (Integer integer : list) {
                sb.append(integer);
                sb.append("->");
            }
            sb.append(root.val);
            ret.add(sb.toString());
        }
        list.add(root.val);
        helper(root.left);
        helper(root.right);
        list.removeLast();
    }
}
