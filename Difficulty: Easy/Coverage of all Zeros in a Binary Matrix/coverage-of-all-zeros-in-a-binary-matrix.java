class Solution {
    public int findCoverage(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int totalCoverage = 0;
        
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    for (int d = 0; d < 4; d++) {
                        int ni = i + dr[d];
                        int nj = j + dc[d];
                        
                        while (ni >= 0 && ni < n && nj >= 0 && nj < m) {
                            if (mat[ni][nj] == 1) {
                                totalCoverage++;
                                break; 
                            }
                            ni += dr[d];
                            nj += dc[d];
                        }
                    }
                }
            }
        }
        
        return totalCoverage;
    }
}