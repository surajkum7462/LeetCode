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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
         // Edge case: If either array is empty, return null
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        return buildTreeHelper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTreeHelper(int[] preorder, int preStart, int preEnd, 
                                     int[] inorder, int inStart, int inEnd) {
        // Base case: If there are no elements to construct the tree
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        // The first element of preorder is the root
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);

        // Find the root in the inorder array
        int rootIndex = inStart;
        while (rootIndex <= inEnd && inorder[rootIndex] != rootVal) {
            rootIndex++;
        }

        // Number of elements in the left subtree
        int leftSize = rootIndex - inStart;

        // Recursively construct the left and right subtrees
        root.left = buildTreeHelper(preorder, preStart + 1, preStart + leftSize, 
                                    inorder, inStart, rootIndex - 1);
        root.right = buildTreeHelper(preorder, preStart + leftSize + 1, preEnd, 
                                     inorder, rootIndex + 1, inEnd);

        return root;
    }
}