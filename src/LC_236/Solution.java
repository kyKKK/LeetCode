package LC_236;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    TreeNode ans = null;

    //  方法1
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ans;
    }

    public boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return false;
        boolean left_exist = dfs(root.left, p, q);
        boolean right_exist = dfs(root.right, p, q);
        if ((left_exist && right_exist) || ((root.val == p.val || root.val == q.val) && (left_exist || right_exist))) {
            ans = root;
        }
        return left_exist || right_exist || (root.val == p.val || root.val == q.val);
    }

    //  方法2
    Map<TreeNode, TreeNode> nodeMap = new HashMap<>();
    Set<TreeNode> nodeSet = new HashSet<>();

    public TreeNode lowestCommonAncestor_1(TreeNode root, TreeNode p, TreeNode q) {
        dfs_1(root);
        while (p != null) {
            nodeSet.add(p);
            p = nodeMap.get(p);
        }
        while (q != null) {
            if (nodeSet.contains(q))
                return q;
            q = nodeMap.get(q);
        }
        return null;
    }

    public void dfs_1(TreeNode root) {
        if (root == null)
            return;
        if (root.left != null)
            nodeMap.put(root.left, root);
        if (root.right != null)
            nodeMap.put(root.right, root);
        dfs_1(root.left);
        dfs_1(root.right);
    }
}
