package LC_450;

//  2020年5月6日
public class Review {
    class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode p = root, pp = null;
        while (true) {
            if (null == p)
                return null;
            if (key > p.val) {
                pp = p;
                p = p.right;
            } else if (key < p.val) {
                pp = p;
                p = p.left;
            } else break;
        }
        if (p.left != null && p.right != null) {
            TreeNode minP = p.right, minPP = p;
            while (minP.left != null) {
                minPP = minP;
                minP = minP.left;
            }
            p.val = minP.val;
            p = minP;
            pp = minPP;
        }
        TreeNode child = null;
        if (p.left != null)
            child = p.left;
        else if (p.right != null)
            child = p.right;
        if (null == pp)
            root = child;
        else if (p == pp.left)
            pp.left = child;
        else
            pp.right = child;
        return root;
    }


}
