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
    List<Integer> list = new ArrayList<>();
      public void inOrder(TreeNode root)
      {
        if(root==null)
        {
            return ;
        }
        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
      }
    public boolean findTarget(TreeNode root, int k) {

        inOrder(root);
       int left = 0, right = list.size() - 1;
        while (left < right) {
            int sum = list.get(left) + list.get(right);
            if (sum == k) {
                return true; // Found the pair
            } else if (sum < k) {
                left++; // Move the left pointer forward
            } else {
                right--; // Move the right pointer backward
            }
        }

        return false; // No such pair exists
    }
}