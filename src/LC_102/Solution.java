package LC_102;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new LinkedList<>();
        List<TreeNode> nodeList = new LinkedList<>();
        nodeList.add(root);
        while (!nodeList.isEmpty() && root != null) {
            int size = nodeList.size();
            List<Integer> integerList = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = nodeList.remove(0);
                integerList.add(node.val);
                if (node.left != null)
                    nodeList.add(node.left);
                if (node.right != null)
                    nodeList.add(node.right);
            }
            ret.add(integerList);
        }
        return ret;
    }

    List<List<Integer>> ret = new ArrayList<>();

    public List<List<Integer>> levelOrder_recur(TreeNode root) {
        helper(root, 0);
        return ret;
    }

    public void helper(TreeNode root, int deep) {
        if (root == null)
            return;
        if (ret.size() == deep)
            ret.add(new LinkedList<>());
        ret.get(deep).add(root.val);
        helper(root.left, deep + 1);
        helper(root.right, deep + 1);
    }
}
