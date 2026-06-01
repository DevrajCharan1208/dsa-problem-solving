class Solution {
    public int findMaxProduct(int[] arr) {
        int n = arr.length;
        if (n == 1) {
            return arr[0];
        }

        long MOD = 1000000007;
        int countNeg = 0;
        int countZero = 0;
        int maxNeg = Integer.MIN_VALUE;
        long prod = 1;

        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                countZero++;
                continue;
            }

            if (arr[i] < 0) {
                countNeg++;
                if (arr[i] > maxNeg) {
                    maxNeg = arr[i];
                }
            }

            prod = (prod * arr[i]) % MOD;
        }

        if (countZero == n) {
            return 0;
        }

        if (countNeg % 2 != 0) {
            if (countNeg == 1 && countZero > 0 && (countNeg + countZero) == n) {
                return 0;
            }
            
            prod = 1;
            boolean skipped = false;
            for (int i = 0; i < n; i++) {
                if (arr[i] == 0) continue;
                if (arr[i] == maxNeg && !skipped) {
                    skipped = true;
                    continue;
                }
                prod = (prod * arr[i]) % MOD;
            }
        }

        return (int) prod;
    }
}