class Solution {
    public ArrayList<Integer> optimalArray(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> result = new ArrayList<>(n);
        
        long leftSum = 0;
        long rightSum = 0;
        
        for (int i = 0; i < n; i++) {
            int m = i / 2;
            
            if (i == 0) {
                leftSum = arr[0];
                result.add(0);
                continue;
            }
            
            if (i % 2 == 1) {
                rightSum += arr[i];
                long ops = rightSum - leftSum;
                result.add((int) ops);
            } else {
                leftSum += arr[m];
                rightSum += arr[i] - arr[m];
                long ops = rightSum - leftSum + arr[m];
                result.add((int) ops);
            }
        }
        
        return result;
    }
}