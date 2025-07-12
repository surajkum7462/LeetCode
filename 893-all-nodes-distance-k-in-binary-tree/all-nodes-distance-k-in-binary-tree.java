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
    public void getParent(TreeNode root,Map<TreeNode,TreeNode> map , TreeNode target)
 {
    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);
    while(!q.isEmpty())
    {
        TreeNode node = q.poll();
        if(node.left!=null)
        {
            map.put(node.left,node);
            q.add(node.left);
        }
        if(node.right!=null)
        {
            map.put(node.right,node);
            q.add(node.right);
        }
    }
 }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parent_track = new HashMap<>();
        getParent(root, parent_track,target);
        Map<TreeNode, Boolean> visited = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();

        q.add(target);
        visited.put(target, true);

        int current_level = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            if (current_level == k) break;
            current_level++;

            for (int i = 0; i < size; i++) {
                TreeNode current = q.poll();

                if (current.left != null && visited.get(current.left) == null) {
                    q.add(current.left);
                    visited.put(current.left, true);
                }

                if (current.right != null && visited.get(current.right) == null) {
                    q.add(current.right);
                    visited.put(current.right, true);
                }

                TreeNode parent = parent_track.get(current);
                if (parent != null && visited.get(parent) == null) {
                    q.add(parent);
                    visited.put(parent, true);
                }
            }
        }

        List<Integer> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            ans.add(node.val);
        }

        return ans;
    }
}