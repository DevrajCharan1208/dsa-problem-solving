class Solution {
    private final int MOD = 1000000007;

    public int computeValue(int n) {
        if (n == 0) return 1;

        long numerator = 1;
        for (int i = 1; i <= 2 * n; i++) {
            numerator = (numerator * i) % MOD;
        }

        long denominator = 1;
        for (int i = 1; i <= n; i++) {
            denominator = (denominator * i) % MOD;
        }
        
        denominator = (denominator * denominator) % MOD;

        long invDenominator = power(denominator, MOD - 2);

        return (int) ((numerator * invDenominator) % MOD);
    }

    private long power(long base, long exp) {
        long res = 1;
        base %= MOD;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                res = (res * base) % MOD;
            }
            base = (base * base) % MOD;
            exp >>= 1;
        }
        return res;
    }
}