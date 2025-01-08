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
    public List<Integer> preorderTraversal(TreeNode root) {
        // List<Integer> pre = new ArrayList<>();
        // if(root==null)
        // {
        //     return pre;
        // }
        //  pre.add(root.val);
        // pre.addAll(preorderTraversal(root.left));
       
        // pre.addAll(preorderTraversal(root.right));
        // return pre;

        //Iterative approach
        
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        if(root==null)
        {
            return list;
        }
        st.push(root);
        while(!st.isEmpty())
        {
            TreeNode temp = st.pop();
            list.add(temp.val);
            if(temp.right!=null)
            {
                st.push(temp.right);
            }
            if(temp.left!=null)
            {
                st.push(temp.left);
            }
        }
        return list;
    }
}