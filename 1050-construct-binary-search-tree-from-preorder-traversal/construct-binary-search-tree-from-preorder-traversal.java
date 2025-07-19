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
    public TreeNode bstFromPreorder(int[] preorder) {

        TreeNode root = new TreeNode(preorder[0]);
        TreeNode temp=root;
        for(int i=1;i<preorder.length;i++)
        {
           insertIntoBst(root,preorder[i]);
        }
        return root;
    }

    private void insertIntoBst(TreeNode root , int val){
        TreeNode current = root;
        while(true)
        {
            if(current.val>val)
            {
                if(current.left==null)
                {
                    current.left=new TreeNode(val);
                    break;
                }
                else{
                    current = current.left;
                }
            }else{
                if(current.right==null)
                {
                    current.right=new TreeNode(val);
                    break;
                }
                else
                {
                    current=current.right;
                }
            }
        }
    }
}