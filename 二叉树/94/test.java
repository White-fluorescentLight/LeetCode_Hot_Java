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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }

    // 辅助递归函数
    private void inorder(TreeNode node, List<Integer> result) {
        // 递归终止条件：节点为空，直接返回
        if (node == null) {
            return;
        }

        // 1. 先遍历左子树
        inorder(node.left, result);
        // 把节点值加入结果列表
        result.add(node.val);
        // 3. 最后遍历右子树
        inorder(node.right, result);
    }
}