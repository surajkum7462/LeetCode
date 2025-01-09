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
 class Pair {
    TreeNode node;
    int index;
    
    public Pair(TreeNode node, int index) {
        this.node = node;
        this.index = index;
    }
}

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int maxWidth = 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0)); // Start with the root node at index 0
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            int minIndex = queue.peek().index; // Minimum index at this level
            int firstIndex = 0, lastIndex = 0;
            
            for (int i = 0; i < size; i++) {
                Pair current = queue.poll();
                int currentIndex = current.index - minIndex; // Normalize index to prevent overflow
                TreeNode currentNode = current.node;
                
                if (i == 0) {
                    firstIndex = currentIndex;
                }
                if (i == size - 1) {
                    lastIndex = currentIndex;
                }
                
                // Add children to the queue with updated indices
                if (currentNode.left != null) {
                    queue.offer(new Pair(currentNode.left, 2 * currentIndex + 1));
                }
                if (currentNode.right != null) {
                    queue.offer(new Pair(currentNode.right, 2 * currentIndex + 2));
                }
            }
            
            maxWidth = Math.max(maxWidth, lastIndex - firstIndex + 1);
        }
        
        return maxWidth;
    }
}