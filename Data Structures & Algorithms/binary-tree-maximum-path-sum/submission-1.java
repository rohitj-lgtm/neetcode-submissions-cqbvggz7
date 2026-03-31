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
    private int maxSum = Integer.MIN_VALUE;
    
    private int dfs(TreeNode root) {
        if (root == null) return 0;
        
        // Get max path sums from children (can be negative, so we use max with 0)
        int leftMax = Math.max(0, dfs(root.left));
        int rightMax = Math.max(0, dfs(root.right));
        
        // Calculate the maximum path sum that goes through this node
        int pathThroughRoot = root.val + leftMax + rightMax;
        
        // Update global maximum
        maxSum = Math.max(maxSum, pathThroughRoot);
        
        // Return the maximum path sum that can be extended upward
        return root.val + Math.max(leftMax, rightMax);
    }
    
    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        dfs(root);
        return maxSum;
    }
}
