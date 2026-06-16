class Solution {
    public ArrayList<Integer> constructList(int[][] queries) {
        ArrayList<Integer> result = new ArrayList<>();
        int cumulativeXor = 0;

        for (int i = queries.length - 1; i >= 0; i--) {
            int type = queries[i][0];
            int x = queries[i][1];

            if (type == 1) {
                cumulativeXor ^= x;
            } else {
                result.add(x ^ cumulativeXor);
            }
        }

        result.add(0 ^ cumulativeXor);

        Collections.sort(result);

        return result;
    }
}