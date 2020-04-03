package LC_701;

//  二叉搜索树中的插入操作
public class LC_701 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }

    //  迭代
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (null == root) {
            return null;
        }
        TreeNode node = root;
        while (null != node) {
            if (val < node.val) {
                if (null == node.left) {
                    node.left = new TreeNode(val);
                    return root;
                }
                node = node.left;
            } else {
                if (null == node.right) {
                    node.right = new TreeNode(val);
                    return root;
                }
                node = node.right;
            }
        }
        return root;
    }
    //  递归
    public TreeNode insertIntoBST_recursive(TreeNode root, int val) {
        if (null == root) {
            return new TreeNode(val);
        }
        if (val < root.val) {
            root.left = insertIntoBST_recursive(root.left, val);
        } else {
            root.right = insertIntoBST_recursive(root.right, val);
        }
        return root;
    }
}
