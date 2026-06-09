class Solution {
    public int binarySearchable(int[] arr) {
        return countSearchable(arr, 0, arr.length - 1, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private int countSearchable(int[] arr, int l, int r, int minAllowed, int maxAllowed) {
        if (l > r) {
            return 0;
        }

        int mid = (l + r) / 2;
        int count = 0;

        if (arr[mid] > minAllowed && arr[mid] < maxAllowed) {
            count = 1;
        }

        int leftPath = countSearchable(arr, l, mid - 1, minAllowed, Math.min(maxAllowed, arr[mid]));
        
        int rightPath = countSearchable(arr, mid + 1, r, Math.max(minAllowed, arr[mid]), maxAllowed);

        return count + leftPath + rightPath;
    }
}