class Solution {
    public ArrayList<ArrayList<Integer>> shortestDist(int[][] mat) {
        int n = mat.length;
        int[][] path = new int[n][n];
        int[][] memo = new int[n][n]; // 0 = unvisited, -1 = dead end
        
        if (solve(0, 0, mat, path, memo, n)) {
            ArrayList<ArrayList<Integer>> result = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                ArrayList<Integer> row = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    row.add(path[i][j]);
                }
                result.add(row);
            }
            return result;
        }
        
        ArrayList<ArrayList<Integer>> noPath = new ArrayList<>();
        ArrayList<Integer> inner = new ArrayList<>();
        inner.add(-1);
        noPath.add(inner);
        return noPath;
    }
    
    private boolean solve(int r, int c, int[][] mat, int[][] path, int[][] memo, int n) {
        if (r == n - 1 && c == n - 1) {
            path[r][c] = 1;
            return true;
        }
        
        if (r >= n || c >= n || mat[r][c] == 0 || memo[r][c] == -1) {
            return false;
        }
        
        path[r][c] = 1;
        int maxJumps = mat[r][c];
        
        for (int jump = 1; jump <= maxJumps; jump++) {
            if (c + jump < n && solve(r, c + jump, mat, path, memo, n)) {
                return true;
            }
            if (r + jump < n && solve(r + jump, c, mat, path, memo, n)) {
                return true;
            }
        }
        
        path[r][c] = 0;
        memo[r][c] = -1; 
        return false;
    }
}