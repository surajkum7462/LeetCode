/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public void markParents(TreeNode root,Map<TreeNode,TreeNode> parentTrack,TreeNode target)
    {
         Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            
            if (current.left != null) {
                parentTrack.put(current.left, current); // Mark parent for left child
                queue.offer(current.left);
            }
            if (current.right != null) {
                parentTrack.put(current.right, current); // Mark parent for right child
                queue.offer(current.right);
            }
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parentTrack = new HashMap<>(); // To store parent pointers
        markParents(root, parentTrack, target); // Mark parent nodes
        
        Map<TreeNode, Boolean> visited = new HashMap<>(); // Track visited nodes
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(target);
        visited.put(target, true);
        int currentLevel = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (currentLevel == k) break; // Stop when we reach the required distance
            currentLevel++;
            
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                
                // Traverse the left child
                if (current.left != null && !visited.containsKey(current.left)) {
                    queue.offer(current.left);
                    visited.put(current.left, true);
                }
                
                // Traverse the right child
                if (current.right != null && !visited.containsKey(current.right)) {
                    queue.offer(current.right);
                    visited.put(current.right, true);
                }
                
                // Traverse the parent
                if (parentTrack.containsKey(current) && !visited.containsKey(parentTrack.get(current))) {
                    queue.offer(parentTrack.get(current));
                    visited.put(parentTrack.get(current), true);
                }
            }
        }
        
        // Collect all nodes at distance K
        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            result.add(queue.poll().val);
        }
        
        return result;
    }
}