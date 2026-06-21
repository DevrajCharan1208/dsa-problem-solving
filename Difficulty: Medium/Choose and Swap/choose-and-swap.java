class Solution {
    public String chooseSwap(String s) {
        int n = s.length();
        int[] firstOccurrence = new int[26];
        Arrays.fill(firstOccurrence, -1);
        
        for (int i = 0; i < n; i++) {
            int charIdx = s.charAt(i) - 'a';
            if (firstOccurrence[charIdx] == -1) {
                firstOccurrence[charIdx] = i;
            }
        }
        
        char charToReplace = ' ';
        char replacementChar = ' ';
        boolean foundSwap = false;
        
        for (int i = 0; i < n; i++) {
            char current = s.charAt(i);
            
            for (char smaller = 'a'; smaller < current; smaller++) {
                int smallerIdx = smaller - 'a';
                
                if (firstOccurrence[smallerIdx] > i) {
                    charToReplace = current;
                    replacementChar = smaller;
                    foundSwap = true;
                    break;
                }
            }
            if (foundSwap) {
                break;
            }
        }
        
        if (!foundSwap) {
            return s;
        }
        
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < n; i++) {
            if (sb.charAt(i) == charToReplace) {
                sb.setCharAt(i, replacementChar);
            } else if (sb.charAt(i) == replacementChar) {
                sb.setCharAt(i, charToReplace);
            }
        }
        
        return sb.toString();
    }
}