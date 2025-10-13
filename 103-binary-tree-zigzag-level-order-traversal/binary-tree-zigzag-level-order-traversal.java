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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
      Queue<TreeNode> q = new LinkedList<>();
      List<List<Integer>> ans = new ArrayList<>();
      if(root==null)
      {
        return ans;
      }
      boolean leftToRight = true;

      q.offer(root);
      while(!q.isEmpty())
      {
         List<Integer> temp = new ArrayList<>();
         int n = q.size();
         for(int i=0;i<n;i++)
         {
            TreeNode node = q.poll();
            if(leftToRight)
            {
                temp.add(node.val);
            }
            else
            {
                temp.add(0,node.val);
            }
            if(node.left!=null)
            {
                q.offer(node.left);
            }
            if(node.right!= null)
            {
                q.offer(node.right);
            }

         }
         leftToRight=!leftToRight;
         ans.add(temp);
      }
      return ans;
    }
}