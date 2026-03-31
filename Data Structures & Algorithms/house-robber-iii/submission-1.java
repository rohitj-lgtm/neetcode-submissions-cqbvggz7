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
    public int rob(TreeNode root) {
        if (root == null) return 0;
        
        Map<TreeNode, int[]> dp = new HashMap<>();
        Stack<TreeNode> stack = new Stack<>();
        Set<TreeNode> visited = new HashSet<>();
        
        stack.push(root);
        
        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            
            if (visited.contains(node)) {
                stack.pop();
                int[] left = dp.getOrDefault(node.left, new int[]{0, 0});
                int[] right = dp.getOrDefault(node.right, new int[]{0, 0});
                int[] ans = new int[2];
                ans[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
                ans[1] = node.val + left[0] + right[0];
                dp.put(node, ans);
            } else {
                visited.add(node);
                if (node.right != null) stack.push(node.right);
                if (node.left != null) stack.push(node.left);
            }
        }
        
        int[] ans = dp.get(root);
        return Math.max(ans[0], ans[1]);
    }
}