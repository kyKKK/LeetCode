package LC_112;

import java.util.LinkedList;
import java.util.Queue;

//  路径总和，BFS
public class Solution2 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }

    Queue<TreeNode> treeNodeQueue = new LinkedList<>();
    Queue<Integer> valQueue = new LinkedList<>();

    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null)
            return false;
        treeNodeQueue.add(root);
        valQueue.add(root.val);
        while (!treeNodeQueue.isEmpty()) {
            int size = treeNodeQueue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = treeNodeQueue.poll();
                int baseVal = valQueue.poll();
                if ((node.left == null && node.right == null) && (sum == baseVal))
                    return true;
                if (node.left != null) {
                    treeNodeQueue.add(node.left);
                    valQueue.add(baseVal + node.left.val);
                }
                if (node.right != null) {
                    treeNodeQueue.add(node.right);
                    valQueue.add(baseVal + node.right.val);
                }
            }
        }
        return false;
    }
}
