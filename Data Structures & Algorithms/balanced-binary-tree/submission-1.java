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
    private boolean isBalanced = true;
    private int dfs(TreeNode node) {
        if(!this.isBalanced) return 0;
        if(node == null) return 0;
        int left = dfs(node.left);
        int right = dfs(node.right);
        if(Math.abs(left - right) > 1){
            this.isBalanced = false;
        }
        return 1 + Math.max(left, right);
    }
    public boolean isBalanced(TreeNode root) {
        dfs(root);
        return this.isBalanced;
    }
}
