class Solution {
    public int maxSumSubarray(int[] arr) {
        int n = arr.length;
        if (n == 1) {
            return arr[0];
        }

        int[] maxEndHere = new int[n];
        int[] maxSkippedEndHere = new int[n];

        maxEndHere[0] = arr[0];
        maxSkippedEndHere[0] = arr[0];
        int overallMax = arr[0];

        for (int i = 1; i < n; i++) {
            maxEndHere[i] = Math.max(arr[i], maxEndHere[i - 1] + arr[i]);
            maxSkippedEndHere[i] = Math.max(maxEndHere[i - 1], maxSkippedEndHere[i - 1] + arr[i]);
            
            overallMax = Math.max(overallMax, Math.max(maxEndHere[i], maxSkippedEndHere[i]));
        }

        return overallMax;
    }
}