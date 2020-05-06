package LC_226;

import java.util.LinkedList;
import java.util.List;

public class Solition {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }

    //  递归
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;
        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    //  迭代
    public TreeNode invertTree_1(TreeNode root) {
        LinkedList<TreeNode> list = new LinkedList<>();
        if(root==null)
            return null;
        list.add(root);
        while (!list.isEmpty()) {
            TreeNode node = list.removeFirst();
            if (null != node.left) {
                list.add(node.left);
            }
            if (null != node.right) {
                list.add(node.right);
            }
            TreeNode tmp = node.right;
            node.right = node.left;
            node.left = tmp;
        }
        return root;
    }

}
