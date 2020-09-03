package LC_110;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution2 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    Map<TreeNode, TreeNode> map = new HashMap<>();
    Set<TreeNode> set = new HashSet<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root);

        while (p != null) {
            set.add(p);
            p = map.get(p);
        }
        while (q != null) {
            if (set.contains(q))
                return q;
            q = map.get(q);
        }
        return null;
    }

    private void dfs(TreeNode node) {
        if (node == null)
            return;
        if (node.left != null)
            map.put(node.left, node);
        if (node.right != null)
            map.put(node.right, node);
        dfs(node.left);
        dfs(node.right);
    }
}
