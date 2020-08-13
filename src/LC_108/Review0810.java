package LC_108;

public class Review0810 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return internal(nums, 0, nums.length - 1);
    }

    private TreeNode internal(int[] nums, int left, int right) {
        if (left > right)
            return null;
        int root_pos = left + ((right - left) >> 2);
        TreeNode root = new TreeNode(nums[root_pos]);
        root.left = internal(nums, left, root_pos - 1);
        root.right = internal(nums, root_pos + 1, right);
        return root;
    }
}
