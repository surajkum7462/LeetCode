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
    public int maxDepth(TreeNode root) {
        // if(root==null)
        // {
        //     return 0;
        // }
        // int lh=maxDepth(root.left);
        // int rh=maxDepth(root.right);
        // return 1+Math.max(lh,rh);

         int cnt=0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        if(root==null)
        {
            return 0;
        }
        while(!q.isEmpty())
        {
           int levelSize=q.size();
           cnt++;
            
           for(int i=0;i<levelSize;i++)
           {

             TreeNode current = q.poll();
             
           
            if(current.left!=null)
            {
                q.offer(current.left);
                
            }
            if(current.right!=null)
            {
                q.offer(current.right);
                
            }
           }
            
        }
        return cnt;
    }
}