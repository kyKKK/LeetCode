package LC_450;

import java.util.logging.Level;

public class Review_1 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode p = root, pp = null, minP = null, minPP = null;
        while (p != null && p.val != key) {
            pp = p;
            if (key > p.val) {
                p = p.right;
            } else {
                p = p.left;
            }
        }
        if (p == null)
            return null;
        if (p.left != null && p.right != null) {
            minP = p.left;
            minPP = p;
            while (minP.right != null) {
                minPP = minP;
                minP = minP.right;
            }
            p.val = minP.val;
            p = minP;
            pp = minPP;
        }
        if (p.left == null && p.right == null) {
            if (pp == null)
                return null;
            if (pp.left == p)
                pp.left = null;
            else
                pp.right = null;
        } else if (p.left != null) {
            if (pp == null)
                root = root.left;
            if (pp.left == p)
                pp.left = p.left;
            else
                pp.right = p.left;
        } else {
            if (pp == null)
                root = root.right;
            if (pp.left == p)
                pp.left = p.right;
            else
                pp.right = p.right;
        }
        return root;

    }


    //  递归
    public TreeNode deleteNode_1(TreeNode root, int key) {
        if (root == null)
            return null;
        if (key > root.val) {
            root.right = deleteNode_1(root.right, key);
        }
        if (key < root.val) {
            root.left = deleteNode_1(root.left, key);
        }
        else if (root.left == null && root.right == null)
            root = null;
        else if (root.left != null && root.right != null) {
            TreeNode node = findPredecessor(root);
            root.val = node.val;
            root.left = deleteNode_1(root.left, node.val);
        } else if (root.left != null) {
            TreeNode node = findPredecessor(root);
            root.val = node.val;
            root.left = deleteNode_1(root.left, node.val);
        } else {
            TreeNode node = findSuccessor(root);
            root.val = node.val;
            root.right = deleteNode_1(root.right, node.val);
        }
        return root;
    }

    private TreeNode findSuccessor(TreeNode node) {
        node = node.right;
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    private TreeNode findPredecessor(TreeNode node) {
        node = node.left;
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }


}
