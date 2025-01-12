class Solution {
    public int orangesRotting(int[][] grid) {
       if (grid == null || grid.length == 0) {
            return 0;
        }
        
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int count_fresh = 0;

        // Parse grid to find rotten oranges and count fresh oranges
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j}); // Add rotten oranges to the queue
                } else if (grid[i][j] == 1) {
                    count_fresh++; // Count fresh oranges
                }
            }
        }

        // If there are no fresh oranges, return 0
        if (count_fresh == 0) return 0;

        int countMin = 0; // Time counter
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        // Perform BFS
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean freshRottenInThisRound = false; // Track if fresh oranges rot in this round

            for (int i = 0; i < size; i++) {
                int[] point = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int x = point[0] + dx[j];
                    int y = point[1] + dy[j];
                    
                    // Skip invalid or already visited cells
                    if (x < 0 || y < 0 || x >= rows || y >= cols || grid[x][y] != 1) {
                        continue;
                    }
                    
                    grid[x][y] = 2; // Mark fresh orange as rotten
                    queue.offer(new int[]{x, y});
                    count_fresh--; // Decrease count of fresh oranges
                    freshRottenInThisRound = true;
                }
            }

            // Increment time if fresh oranges were rotten in this round
            if (freshRottenInThisRound) {
                countMin++;
            }
        }

        // If there are fresh oranges left, return -1
        return count_fresh == 0 ? countMin : -1;
    }
}