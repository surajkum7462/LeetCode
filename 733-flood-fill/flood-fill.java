class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

         if (image == null || image.length == 0) return image;

        Queue<int[]> q = new LinkedList<>();
        int row = image.length;
        int col = image[0].length;
       
       int originalColor = image[sr][sc];
       if(originalColor==color)
       {
         return image;
       }

      q.offer(new int[]{sr,sc});
      image[sr][sc]=color;
        

       

       
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        // Step 2: BFS traversal
        while (!q.isEmpty()) {
           
            

           
                int[] point = q.poll();

                for (int j = 0; j < 4; j++) {
                    int x = point[0] + dx[j];
                    int y = point[1] + dy[j];

                    if (x < 0 || y < 0 || x >= row || y >= col || image[x][y] != originalColor) {
                        continue;
                    }

                    image[x][y] = color;
                   
                    q.offer(new int[]{x, y});
                    
                }
            

           
        }

        return image;
        
    }
}