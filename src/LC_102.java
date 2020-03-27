import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//  二叉树的层次遍历
public class LC_102 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //  迭代
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (null == root)
            return list;
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if (null != node.left)
                    queue.offer(node.left);
                if (null != node.right)
                    queue.offer(node.right);
            }
            list.add(tmp);
        }
        return list;
    }

    static List<List<Integer>> ret_list = new ArrayList<>();

    //   递归
    public static List<List<Integer>> levelOrder_recur(TreeNode root) {
        if (null == root)
            return ret_list;
        help(root, 0);
        return ret_list;
    }

    public static void help(TreeNode node, int level) {
        if (level == ret_list.size()) {
            ret_list.add(new ArrayList<>());
        }
        ret_list.get(level).add(node.val);
        if (null != node.left) {
            help(node.left, level + 1);
        }
        if (null != node.right) {
            help(node.right, level + 1);
        }
    }
}
