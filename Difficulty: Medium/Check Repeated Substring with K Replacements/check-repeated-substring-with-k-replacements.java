class Solution {
    public boolean kSubstr(String s, int k) {
        int n = s.length();
        
        if (n % k != 0) {
            return false;
        }
        
        Map<String, Integer> chunkCounts = new HashMap<>();
        
        for (int i = 0; i < n; i += k) {
            String chunk = s.substring(i, i + k);
            chunkCounts.put(chunk, chunkCounts.getOrDefault(chunk, 0) + 1);
        }
        
        if (chunkCounts.size() == 1) {
            return true;
        }
        
        if (chunkCounts.size() == 2) {
            for (int count : chunkCounts.values()) {
                if (count == 1) {
                    return true;
                }
            }
        }
        
        return false;
    }
}