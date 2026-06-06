class Solution {
    public int numOfWays(int n, int m) {
        long totalSquares = (long) n * m;
        long totalWays = totalSquares * (totalSquares - 1);
        
        long invalidWays = 0;
        
        if (n >= 2 && m >= 3) {
            invalidWays += 4L * (n - 1) * (m - 2);
        }
        
        if (n >= 3 && m >= 2) {
            invalidWays += 4L * (n - 2) * (m - 1);
        }
        
        return (int) (totalWays - invalidWays);
    }
}