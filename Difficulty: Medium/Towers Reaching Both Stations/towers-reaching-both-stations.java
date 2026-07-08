
class Solution {
    public int countCoordinates(int[][] mat) {
        if (mat == null || mat.length == 0 || mat[0].length == 0) {
            return 0;
        }
        
        int n = mat.length;
        int m = mat[0].length;
        
        boolean[][] reachP = new boolean[n][m];
        boolean[][] reachQ = new boolean[n][m];
        
        Queue<int[]> queueP = new LinkedList<>();
        Queue<int[]> queueQ = new LinkedList<>();
        
        // Initialize Station P boundaries (Top row and Left column)
        for (int i = 0; i < n; i++) {
            reachP[i][0] = true;
            queueP.offer(new int[]{i, 0});
        }
        for (int j = 1; j < m; j++) {
            reachP[0][j] = true;
            queueP.offer(new int[]{0, j});
        }
        
        // Initialize Station Q boundaries (Bottom row and Right column)
        for (int i = 0; i < n; i++) {
            reachQ[i][m - 1] = true;
            queueQ.offer(new int[]{i, m - 1});
        }
        for (int j = 0; j < m - 1; j++) {
            reachQ[n - 1][j] = true;
            queueQ.offer(new int[]{n - 1, j});
        }
        
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        
        // BFS for Station P
        bfs(mat, queueP, reachP, dirs, n, m);
        // BFS for Station Q
        bfs(mat, queueQ, reachQ, dirs, n, m);
        
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (reachP[i][j] && reachQ[i][j]) {
                    count++;
                }
            }
        }
        
        return count;
    }
    
    private void bfs(int[][] mat, Queue<int[]> queue, boolean[][] reach, int[][] dirs, int n, int m) {
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];
            
            for (int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                
                if (nr >= 0 && nr < n && nc >= 0 && nc < m && !reach[nr][nc]) {
                    if (mat[nr][nc] >= mat[r][c]) {
                        reach[nr][nc] = true;
                        queue.offer(new int[]{nr, nc});
                    }
                }
            }
        }
    }
}