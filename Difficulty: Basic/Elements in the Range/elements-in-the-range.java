class Solution {
    public boolean checkElements(int start, int end, int[] arr) {
        Arrays.sort(arr);
        int idx = 0;
        for(int i = 0; i<arr.length;i++){
            if(arr[i]==start){
                idx = i;
                break;
            }
        }
        for(int i = start; i<=end; i++){
            if(arr[idx] == i){
                idx++;
            }else{
                return false;
            }
        }
        return true;
    }
}