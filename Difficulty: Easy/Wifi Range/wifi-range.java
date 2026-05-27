class Solution {
    public boolean wifiRange(String s, int x) {
        int n = s.length();
        int reach = -1;
        
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                if (i - x > reach + 1) {
                    return false; 
                }
                reach = Math.max(reach, i + x);
            }
        }
        
        return reach >= n - 1;
    }
}