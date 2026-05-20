class Solution {
    public boolean isProduct(int[] arr, long target) {
        // code here
        Arrays.sort(arr);
        int l = 0;
        int r = arr.length-1;
        while(l<r){
            long product = (long)arr[l]*arr[r];
            if(product == target){
                return true;
            }else if(product>target){
                r--;
            }else{
                l++;
            }
        }
        return false;
    }
};