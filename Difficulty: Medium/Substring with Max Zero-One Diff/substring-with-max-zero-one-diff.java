class Solution {
    int maxSubstring(String s) {
        int maxDiff = -1;
        int currentSum = 0;
        boolean hasZero = false;

        for (int i = 0; i < s.length(); i++) {
            int val = (s.charAt(i) == '0') ? 1 : -1;
            
            if (val == 1) {
                hasZero = true;
            }

            currentSum += val;

            if (currentSum > maxDiff) {
                maxDiff = currentSum;
            }

            if (currentSum < 0) {
                currentSum = 0;
            }
        }

        return hasZero ? maxDiff : -1;
    }
}