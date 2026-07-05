
class Solution {
    public int maxCharGap(String s) {
        int[] firstOccur = new int[26];
        Arrays.fill(firstOccur, -1);
        
        int maxGap = -1;
        
        for (int i = 0; i < s.length(); i++) {
            int charIdx = s.charAt(i) - 'a';
            
            if (firstOccur[charIdx] == -1) {
                firstOccur[charIdx] = i;
            } else {
                int currentGap = i - firstOccur[charIdx] - 1;
                maxGap = Math.max(maxGap, currentGap);
            }
        }
        
        return maxGap;
    }
}