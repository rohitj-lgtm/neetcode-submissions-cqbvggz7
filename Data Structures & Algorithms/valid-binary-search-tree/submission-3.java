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
        if(root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        Stack<Long> minStack = new Stack<>();
        Stack<Long> maxStack = new Stack<>();

        stack.push(root);
        minStack.push(Long.MIN_VALUE);
        maxStack.push(Long.MAX_VALUE);

        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            long min = minStack.pop();
            long max = maxStack.pop();

            if(node.val >= max || node.val <= min) return false;
            if(node.left != null) {
                stack.push(node.left);
                minStack.push(min);
                maxStack.push((long) node.val);
            }
            if(node.right != null) {
                stack.push(node.right);
                maxStack.push(max);
                minStack.push((long) node.val);
            }
        }

        return true;
    }
}
