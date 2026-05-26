class Solution {
    int minToggle(int[] arr) {
        int onesCount = 0;
        int flipCount = 0;

        for (int num : arr) {
            if (num == 1) {
                onesCount++;
            } else {
                flipCount = Math.min(flipCount + 1, onesCount);
            }
        }

        return flipCount;
    }
}