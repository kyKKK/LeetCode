package LC_104;

import java.util.LinkedList;
import java.util.List;

//  2020年5月7日
class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;

    TreeNode(int x) {
        val = x;
    }
}

public class Review {
    //  递归
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    //  BFS
    public int maxDepth_1(TreeNode root) {
        if (null == root) {
            return 0;
        }
        List<List<TreeNode>> ret = new LinkedList<>();
        List<TreeNode> nodeList = new LinkedList<>();
        nodeList.add(root);
        while (nodeList.size() != 0) {
            ret.add(new LinkedList<>(nodeList));
            int size = nodeList.size();
            while (size > 0) {
                TreeNode tmp = nodeList.remove(0);
                if (tmp.left != null)
                    nodeList.add(tmp.left);
                if (tmp.right != null)
                    nodeList.add(tmp.right);
                --size;
            }
        }
        return ret.size();
    }
}
