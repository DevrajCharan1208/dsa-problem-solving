class Solution {
    private int[] bit;
    private int size;

    private void update(int idx, int val) {
        for (; idx <= size; idx += idx & -idx) {
            bit[idx] += val;
        }
    }

    private int query(int idx) {
        int sum = 0;
        for (; idx > 0; idx -= idx & -idx) {
            sum += bit[idx];
        }
        return sum;
    }

    public int countSubstring(String s) {
        int n = s.length();
        size = 2 * n + 2;
        bit = new int[size + 1];

        int offset = n + 1;
        int currentSum = 0;
        int totalSubstrings = 0;

        update(currentSum + offset, 1);

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                currentSum += 1;
            } else {
                currentSum -= 1;
            }

            totalSubstrings += query(currentSum + offset - 1);

            update(currentSum + offset, 1);
        }

        return totalSubstrings;
    }
}