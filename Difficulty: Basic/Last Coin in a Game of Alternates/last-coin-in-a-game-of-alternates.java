class Solution {
    public int coin(int[] arr) {
        // code here
        int l = 0;
        int r = arr.length-1;
        
        while(l<r-1){
            if (arr[l]>=arr[r]){
                l++;
            }else{
                r--;
            }
        }
        return Math.min(arr[l],arr[r]);
    }
}