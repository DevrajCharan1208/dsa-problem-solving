class Solution {
    public String lexicographicallySmallest(String s, int k) {
        int n = s.length();
        long longK = k; // Use long to prevent overflow bugs
        
        if (n > 0 && (n & (n - 1)) == 0) {
            longK /= 2;
        } else {
            longK *= 2;
        }
        
        if (longK >= n) {
            return "-1";
        }
        if (longK <= 0) {
            return s; // If we need to remove 0 or fewer characters, return the string as-is
        }
        
        Stack<Character> stack = new Stack<>();
        long removalsLeft = longK;
        
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            
            while (!stack.isEmpty() && stack.peek() > ch && removalsLeft > 0) {
                stack.pop();
                removalsLeft--;
            }
            stack.push(ch);
        }
        
        while (removalsLeft > 0 && !stack.isEmpty()) {
            stack.pop();
            removalsLeft--;
        }
        
        StringBuilder sb = new StringBuilder();
        for (char ch : stack) {
            sb.append(ch);
        }
        
        return sb.toString();
    }
}