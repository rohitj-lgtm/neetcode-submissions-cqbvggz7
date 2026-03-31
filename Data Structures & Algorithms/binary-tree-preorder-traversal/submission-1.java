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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stk = new Stack<>();

        if(root != null) {
            stk.push(root);
        }

        while(!stk.isEmpty()) {
            TreeNode curr = stk.pop();
            result.add(curr.val);

            if(curr.right != null) {
                stk.push(curr.right);
            }

            if(curr.left != null) {
                stk.push(curr.left);
            }
        }

        return result;
    }
}