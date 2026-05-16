class Solution {
    public int findSmallest(int[] arr) {
        // code here
        Arrays.sort(arr);
        
        int result = 1;
        
        for(int i = 0;i<arr.length;i++){
            if(arr[i]<=result){
                result += arr[i];
            }else{
                break;
            }
        }
        return result;
    }
}