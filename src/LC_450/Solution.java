package LC_450;

//  删除二叉搜索树中的节点
public class Solution {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode p = root;
        TreeNode pp = null;
        while (null != p && p.val != key) {
            if (key < p.val) {
                pp = p;
                p = p.left;
            } else {
                pp = p;
                p = p.right;
            }
        }
        if (null == p) {
            return root;
        }

        if (null != p.left && null != p.right) {
            TreeNode minPP = p;
            TreeNode minP = p.right;
            while (null != minP.left) {
                minPP = minP;
                minP = minP.left;
            }
            p.val = minP.val;
            p = minP;
            pp = minPP;
        }
        TreeNode child;
        if (null != p.left) {
            child = p.left;
        } else if (null != p.right) {
            child = p.right;
        } else {
            child = null;
        }
        if (null == pp) {
            root = child;
        } else if (pp.left == p) {
            pp.left = child;
        } else {
            pp.right = child;
        }
        return root;
    }

    //  递归
    public TreeNode deleteNode_recur(TreeNode root, int key) {
        if (root == null)
            return null;
        else if (key > root.val)
            root.right = deleteNode_recur(root.right, key);
        else if (key < root.val)
            root.left = deleteNode_recur(root.left, key);
        else {
            if (root.right != null) {
                TreeNode successor = successor(root);
                root.val = successor.val;
                root.right = deleteNode_recur(root.right, root.val);
            } else if (root.left != null) {
                TreeNode predecessor = predecessor(root);
                root.val = predecessor.val;
                root.left = deleteNode_recur(root.left, root.val);
            } else root = null;
        }
        return root;

    }

    public TreeNode successor(TreeNode root) {
        TreeNode p = root;
        if (root.right != null) {
            p = root.right;
            while (null != p.left) {
                p = p.left;
            }
        }
        return p;
    }

    public TreeNode predecessor(TreeNode root) {
        TreeNode p = root;
        if (p.left != null) {
            p = p.left;
            while (null != p.right) {
                p = p.right;
            }
        }
        return p;
    }
}
