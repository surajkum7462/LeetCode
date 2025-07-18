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
    int ans=0;
    int cnt=0;
    public int kthSmallest(TreeNode root, int k) {
        
        helpSmallest(root,k);
        return ans;
       
        
    }
    public void helpSmallest(TreeNode root , int k)
    {
        if(root==null)
        {
            return ;
        }
        helpSmallest(root.left,k);
        cnt++;
        if(cnt==k)
        {
            ans=root.val;
        }
         helpSmallest(root.right,k);
       
    }
}