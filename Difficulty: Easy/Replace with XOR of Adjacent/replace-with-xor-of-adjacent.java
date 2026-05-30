class Solution {
    public void replaceElements(int[] arr) {
        int n = arr.length;
        if (n <= 1) {
            return;
        }

        int org = arr[0];
        arr[0] = arr[0] ^ arr[1];

        for (int i = 1; i < n - 1; i++) {
            int temp = arr[i];
            arr[i] = org ^ arr[i + 1];
            org = temp;
        }

        arr[n - 1] = org ^ arr[n - 1];
    }
}