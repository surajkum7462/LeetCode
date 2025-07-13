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
    public int countNodes(TreeNode root) {
        if(root==null)
        {
            return 0;
        }
        int[] arr = new int[1];
        help(root,arr);
        return arr[0];
        
    }
    public void help(TreeNode node,int[] arr)
    {
        if(node==null)
        {
            return ;
        }
        help(node.left,arr);
        arr[0]++;
        help(node.right,arr);
    }
}