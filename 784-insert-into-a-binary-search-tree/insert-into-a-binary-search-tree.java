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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode newR=root;
        if (root == null) {
            return new TreeNode(val);
        }
        while(true)
        {
            if(val>newR.val)
            {
                if(newR.right==null)
                {
                    newR.right=new TreeNode(val);
                    break;
                }
                newR=newR.right;
            }
            else
            {
                if(newR.left==null)
                {
                    newR.left=new TreeNode(val);
                    break;
                }
                newR=newR.left;
            }
        }
        return root;
    }
}