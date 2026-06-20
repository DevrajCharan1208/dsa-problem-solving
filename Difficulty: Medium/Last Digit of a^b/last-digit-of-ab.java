class Solution {
    public int getLastDigit(String a, String b) {
    
    int n = a.length();
    int m = b.length();
    
    int d_a = Character.getNumericValue(a.charAt(n-1));
    long d_b = 0;
        for (int i = 0; i < b.length(); i++) {
            d_b = (d_b * 10 + Character.getNumericValue(b.charAt(i))) % 4;
        }
        
        if (d_b == 0) {
            d_b = 4;
        }
    
    if(d_b == 0){
        d_b = 4;
    }
    
    int result = 1;
    for (int i = 0; i < d_b; i++) {
        result *= d_a;
    }

    return result%10;
    
    }
};