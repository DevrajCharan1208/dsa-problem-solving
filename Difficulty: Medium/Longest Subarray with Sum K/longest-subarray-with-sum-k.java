// User function Template for Java

import java.util.HashMap;

class Solution {
    public int longestSubarray(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int sum = 0;
        int longest = 0;
        
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            
            if (sum == k) {
                longest = i + 1;
            }
            
            if (map.containsKey(sum - k)) {
                int previousIndex = map.get(sum - k);
                int currentLength = i - previousIndex;
                longest = Math.max(longest, currentLength);
            }
            
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        
        return longest;
    }
}