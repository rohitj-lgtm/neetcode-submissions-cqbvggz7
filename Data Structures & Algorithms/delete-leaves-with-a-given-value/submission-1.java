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
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        Stack<TreeNode> stack = new Stack<>();
        Set<TreeNode> visit = new HashSet<>();
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        stack.push(root);
        parent.put(root, null);
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if(node.left == null && node.right == null) {
                if(node.val == target) {
                    TreeNode parentNode = parent.get(node);
                    if(parentNode == null) {
                        return null;
                    }
                    if(parentNode.left == node) {
                        parentNode.left = null;
                    }
                    if(parentNode.right == node) {
                        parentNode.right = null;
                    }

                }
            } else if(!visit.contains(node)) {
                visit.add(node);
                stack.push(node);
                if(node.left != null){
                    stack.push(node.left);
                    parent.put(node.left, node);
                }
                if(node.right != null){
                    stack.push(node.right);
                    parent.put(node.right, node);
                }
            }
        }
        return root;
    }
}