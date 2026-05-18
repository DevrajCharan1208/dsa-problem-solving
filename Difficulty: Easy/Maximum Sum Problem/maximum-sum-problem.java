class Solution {
    public int maxSum(int n) {
        if(n<=11){
            return n;
        }
        int sum = maxSum(n/2)+maxSum(n/3)+maxSum(n/4);
        
        return sum;
        
    }
}
