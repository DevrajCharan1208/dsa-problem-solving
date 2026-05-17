class Solution {
    List<Integer> makeBeautiful(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        
        for (int currentNum : arr) {
            if (list.isEmpty()) {
                list.add(currentNum);
            } else {
                int lastElement = list.get(list.size() - 1);
                
                boolean lastIsNegative = lastElement < 0;
                boolean currentIsNegative = currentNum < 0;
                
                if (lastIsNegative != currentIsNegative) {
                    list.remove(list.size() - 1);
                } else {
                    list.add(currentNum);
                }
            }
        }
        
        return list;
    }
}