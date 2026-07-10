class Solution {
    public int getCount(int n) {
        int count = 0;
        
        for (int L = 2; ; L++) {
            long sumL = (long) L * (L - 1) / 2;
            if (sumL >= n) {
                break;
            }
            
            if ((n - sumL) % L == 0) {
                count++;
            }
        }
        
        return count;
    }
}