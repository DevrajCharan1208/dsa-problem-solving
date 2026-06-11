class Solution {
    public int findIndex(String s) {
        int totalClosing = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                totalClosing++;
            }
        }
        return totalClosing;
    }
}