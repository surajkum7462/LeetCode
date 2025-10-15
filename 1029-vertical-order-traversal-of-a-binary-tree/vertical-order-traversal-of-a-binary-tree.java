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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
          List<int[]> nodes = new ArrayList<>(); // store {col, row, val}
        dfs(root, 0, 0, nodes);

        // Sort by column, then row, then value
        Collections.sort(nodes, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];  // sort by col
            if (a[1] != b[1]) return a[1] - b[1];  // sort by row
            return a[2] - b[2];                    // sort by value
        });

        // Group by column
        List<List<Integer>> result = new ArrayList<>();
        int prevCol = Integer.MIN_VALUE;
        List<Integer> colList = new ArrayList<>();

        for (int[] n : nodes) {
            int col = n[0], val = n[2];
            if (col != prevCol) {
                if (!colList.isEmpty()) result.add(colList);
                colList = new ArrayList<>();
                prevCol = col;
            }
            colList.add(val);
        }
        result.add(colList);

        return result;
    }
     private void dfs(TreeNode node, int row, int col, List<int[]> list) {
        if (node == null) return;
        list.add(new int[]{col, row, node.val});
        dfs(node.left, row + 1, col - 1, list);
        dfs(node.right, row + 1, col + 1, list);
    }
}