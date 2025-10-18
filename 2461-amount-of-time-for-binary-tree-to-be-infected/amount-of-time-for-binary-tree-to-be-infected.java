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
    public int amountOfTime(TreeNode root, int start) {
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        TreeNode startNode = buildParentMap(root, parentMap, start);
        return bfsToInfect(parentMap, startNode);
    }
     private TreeNode buildParentMap(TreeNode root, Map<TreeNode, TreeNode> parentMap, int start) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        TreeNode target = null;

        while (!q.isEmpty()) {
            TreeNode node = q.poll();

            if (node.val == start) {
                target = node;
            }

            if (node.left != null) {
                parentMap.put(node.left, node);
                q.offer(node.left);
            }

            if (node.right != null) {
                parentMap.put(node.right, node);
                q.offer(node.right);
            }
        }

        return target;
    }
    private int bfsToInfect(Map<TreeNode, TreeNode> parentMap, TreeNode startNode) {
        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        q.offer(startNode);
        visited.add(startNode);

        int time = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            boolean spread = false;

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();

                if (node.left != null && !visited.contains(node.left)) {
                    q.offer(node.left);
                    visited.add(node.left);
                    spread = true;
                }

                if (node.right != null && !visited.contains(node.right)) {
                    q.offer(node.right);
                    visited.add(node.right);
                    spread = true;
                }

                TreeNode parent = parentMap.get(node);
                if (parent != null && !visited.contains(parent)) {
                    q.offer(parent);
                    visited.add(parent);
                    spread = true;
                }
            }

            if (spread) time++;
        }

        return time;
    }
}