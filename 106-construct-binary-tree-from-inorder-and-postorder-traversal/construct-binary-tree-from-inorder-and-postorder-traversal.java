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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // Edge case: If input arrays are empty, return null
        if (inorder == null || postorder == null || inorder.length == 0 || postorder.length == 0) {
            return null;
        }
        
        // Call helper function with appropriate indices
        return buildTreeHelper(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private static TreeNode buildTreeHelper(int[] postorder, int postStart, int postEnd,
                                            int[] inorder, int inStart, int inEnd) {
        // Base case: If there are no elements to construct the tree
        if (postStart > postEnd || inStart > inEnd) {
            return null;
        }

        // Root is the last element of the current postorder range
        int rootValue = postorder[postEnd];
        TreeNode root = new TreeNode(rootValue);

        // Find the root index in the inorder array
        int rootIndex = inStart;
        while (rootIndex <= inEnd && inorder[rootIndex] != rootValue) {
            rootIndex++;
        }

        // Number of nodes in the left subtree
        int leftSize = rootIndex - inStart;

        // Construct left and right subtrees recursively
        root.left = buildTreeHelper(postorder, postStart, postStart + leftSize - 1,
                                    inorder, inStart, rootIndex - 1);
        root.right = buildTreeHelper(postorder, postStart + leftSize, postEnd - 1,
                                     inorder, rootIndex + 1, inEnd);

        return root;
    }
}