package LC_103;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }

    //  BFS
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ret = new LinkedList<>();
        LinkedList<Integer> val_list = new LinkedList<>();
        LinkedList<TreeNode> node_list = new LinkedList<>();
        if (root == null)
            return ret;
        node_list.addLast(root);
        boolean left_travel = true;
        while (node_list.size() > 0) {
            int len = node_list.size();
            for (int i = 0; i < len; i++) {
                if (left_travel) {
                    TreeNode node = node_list.removeFirst();
                    if (node != null) {
                        val_list.add(node.val);
                        node_list.addLast(node.left);
                        node_list.addLast(node.right);
                    }

                } else {
                    TreeNode node = node_list.removeLast();
                    if (node != null) {
                        val_list.add(node.val);
                        node_list.addFirst(node.right);
                        node_list.addFirst(node.left);
                    }
                }
            }
            if (node_list.size() != 0)
                ret.add(val_list);

            val_list = new LinkedList<>();
            left_travel = !left_travel;
        }
        return ret;
    }

    List<List<Integer>> ret = new LinkedList<>();

    //  DFS
    public List<List<Integer>> zigzagLevelOrder_1(TreeNode root) {
        help(root, 0);
        return ret;
    }

    public void help(TreeNode root, int level) {
        if (root == null)
            return;
        if (ret.size() <= level) {
            ret.add(new LinkedList<Integer>());
        }
        List<Integer> list = ret.get(level);
        if (level % 2 == 1) {
            list.add(0, root.val);
        } else {
            list.add(root.val);
        }
        help(root.left, level + 1);
        help(root.right, level + 1);
    }
}
