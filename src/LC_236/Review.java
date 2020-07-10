package LC_236;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Review {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private TreeNode ans = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ans;
    }

    public boolean dfs(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null)
            return false;
        boolean left_exist = dfs(node.left, p, q);
        boolean right_exist = dfs(node.right, p, q);
        if (left_exist && right_exist || (left_exist || right_exist) && (node.val == p.val || node.val == q.val)) {
            ans = node;
        }
        return left_exist || right_exist || (node.val == p.val || node.val == q.val);
    }

    Map<TreeNode, TreeNode> map = new HashMap<>();

    public TreeNode lowestCommonAncestor_1(TreeNode root, TreeNode p, TreeNode q) {
        internal(root);
        Set<TreeNode> set = new HashSet<>();
        while (p != null) {
            set.add(map.get(p));
            p = map.get(p);
        }
        if (set.isEmpty()) {
            return p;
        }
        while (q != null) {
            if (set.contains(q) || map.get(q) == null) {
                return q;
            }
            q = map.get(q);
        }
        return q;

    }

    public void internal(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            map.put(node.left, node);
            internal(node.left);
        }
        if (node.right != null) {
            map.put(node.right, node);
            internal(node.right);
        }

    }

}
