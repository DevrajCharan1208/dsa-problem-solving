class Solution {
    public int maxPathSum(int[] a, int[] b) {
        int n = a.length;
        int m = b.length;
        
        int i = 0, j = 0;
        int sumA = 0, sumB = 0;
        int totalMaxSum = 0;
        
        while (i < n && j < m) {
            if (a[i] < b[j]) {
                sumA += a[i++];
            } else if (b[j] < a[i]) {
                sumB += b[j++];
            } else {
                totalMaxSum += Math.max(sumA, sumB) + a[i];
                sumA = 0;
                sumB = 0;
                i++;
                j++;
            }
        }
        
        while (i < n) {
            sumA += a[i++];
        }
        
        while (j < m) {
            sumB += b[j++];
        }
        
        totalMaxSum += Math.max(sumA, sumB);
        
        return totalMaxSum;
    }
}