package LC_108;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return internal(nums, 0, nums.length - 1);
    }

    private TreeNode internal(int[] nums, int left, int right) {
        if (left > right)
            return null;
        if (left == right)
            return new TreeNode(nums[left]);
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = internal(nums, left, mid - 1);
        root.right = internal(nums, mid + 1, right);
        return root;
    }
}
