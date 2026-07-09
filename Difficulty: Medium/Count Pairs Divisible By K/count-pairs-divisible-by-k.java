
class Solution {
    public int countKdivPairs(int[] arr, int k) {
        int[] remCount = new int[k];
        int pairCount = 0;
        
        for (int num : arr) {
            int rem = ((num % k) + k) % k;
            
            int complement = (k - rem) % k;
            
            pairCount += remCount[complement];
            
            remCount[rem]++;
        }
        
        return pairCount;
    }
}