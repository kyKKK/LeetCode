import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

//  34、二叉树的中序遍历
public class LC_34 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //  迭代
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret_list = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        while (null != node || !stack.isEmpty()) {
            while (null != node) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            ret_list.add(node.val);
            node = node.right;
        }
        return ret_list;
    }

    //  递归
    public List<Integer> inorderTraversal_recursive(TreeNode root) {
        List<Integer> retList = new ArrayList<>();
        traversalRecursive(root, retList);
        return retList;
    }

    public List<Integer> traversalRecursive(TreeNode node, List<Integer> retList) {
        if (null == node)
            return null;
        traversalRecursive(node.left, retList);
        retList.add(node.val);
        traversalRecursive(node.right, retList);
        return retList;
    }

}
