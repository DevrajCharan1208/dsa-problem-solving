class Solution {
    public List<Integer> exitPoint(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        
        int i = 0, j = 0;
        int dir = 0;
        
        List<Integer> ans = new ArrayList<>();
        
        while (true) {
            if (mat[i][j] == 1) {
                mat[i][j] = 0;
                dir = (dir + 1) % 4; 
            }
            
            int nextI = i + dr[dir];
            int nextJ = j + dc[dir];
            
            if (nextI < 0 || nextI >= n || nextJ < 0 || nextJ >= m) {
                ans.add(i);
                ans.add(j);
                return ans;
            }
            
            i = nextI;
            j = nextJ;
        }
    }
}