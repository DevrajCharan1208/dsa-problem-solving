class Solution {
    public int minimumCost(int[] cost, int w) {
        int[] dp = new int[w + 1];
        
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        
        for (int i = 1; i <= w; i++) {
            for (int j = 0; j < cost.length; j++) {
                int packetWeight = j + 1;
                
                if (cost[j] != -1 && packetWeight <= i) {
                    if (dp[i - packetWeight] != Integer.MAX_VALUE) {
                        dp[i] = Math.min(dp[i], cost[j] + dp[i - packetWeight]);
                    }
                }
            }
        }
        
        return dp[w] == Integer.MAX_VALUE ? -1 : dp[w];
    }
}