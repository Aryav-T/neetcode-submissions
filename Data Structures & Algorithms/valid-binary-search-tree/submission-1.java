/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public boolean isValidBST(TreeNode root) {
        return checkValid(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    public boolean checkValid(TreeNode root, Integer max, Integer min){
        if(root == null) return true;
        if(max != Integer.MAX_VALUE && root.val >= max) return false;
        if(min != Integer.MIN_VALUE && root.val <= min) return false;
        return checkValid(root.left, root.val, min) && checkValid(root.right, max, root.val);
        
    }
}
