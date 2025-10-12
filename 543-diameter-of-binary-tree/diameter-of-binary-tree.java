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
    public int diameterOfBinaryTree(TreeNode root) {
    int[] cnt = new int[1];
  findDiameter(cnt,root);
    return cnt[0];

    }
    
    public int findDiameter(int[] cnt , TreeNode root)
    {
        if(root==null)
        {
            return 0;
        }

        int lh = findDiameter(cnt,root.left);
        int rh = findDiameter(cnt,root.right);

        cnt[0]=Math.max(cnt[0],lh+rh);
        return 1+Math.max(rh,lh);
    }
}