class Solution {
    public boolean isBitSet(int n) {
        // code here
        String str = Integer.toBinaryString(n);
        if(str.contains("0")){
            return false;
        }else{
            return true;
        }
    }
};