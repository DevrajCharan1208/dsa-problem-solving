class Solution {
    public int findMin(int n) {
        int count = 0;
        while(n>=10){
            n-=10;
            count++;
        }
        while(n>=5){
            n-=5;
            count++;
        }
        while(n>=2){
            n-=2;
            count++;
        }
        while(n>=1){
            n-=1;
            count++;
        }
        return count;
    }
}
