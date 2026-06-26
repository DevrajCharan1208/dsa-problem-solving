class Solution {
    public static int countWays(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int MOD = 1000000007;
        
        int[] dp = new int[n + 1];
        dp[0] = 1;
        
        for (int i = 1; i <= m; i++) {
            char c1 = s1.charAt(i - 1);
            for (int j = n; j >= 1; j--) {
                if (c1 == s2.charAt(j - 1)) {
                    dp[j] = (dp[j] + dp[j - 1]) % MOD;
                }
            }
        }
        
        return dp[n];
    }
}