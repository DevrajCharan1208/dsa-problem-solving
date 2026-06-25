
class Solution {
    public static ArrayList<Integer> increasingNumbers(int n) {
        ArrayList<Integer> result = new ArrayList<>();
        
        if (n == 1) {
            for (int i = 0; i <= 9; i++) {
                result.add(i);
            }
            return result;
        }
        
        generate(1, 0, n, result);
        return result;
    }
    
    private static void generate(int startDigit, int currentNum, int digitsLeft, ArrayList<Integer> result) {
        if (digitsLeft == 0) {
            result.add(currentNum);
            return;
        }
        
        for (int i = startDigit; i <= 9; i++) {
            generate(i + 1, currentNum * 10 + i, digitsLeft - 1, result);
        }
    }
}