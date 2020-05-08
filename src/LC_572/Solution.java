package LC_572;

class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;

    TreeNode(int x) {
        x = val;
    }
}

public class Solution {


    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(t==null)
            return true;
        if(s==null)
            return false;
        return isSubtree(s.left, t) || isSubtree(s.right, t) || help(s, t);
    }

    public boolean help(TreeNode s, TreeNode t) {
        if (s == null && t == null)
            return true;
        else if (s == null)
            return false;
        else if (t == null)
            return false;
        if (s.val != t.val)
            return false;
        else return help(s.left, t.left) && help(s.right, t.right);
    }




}
