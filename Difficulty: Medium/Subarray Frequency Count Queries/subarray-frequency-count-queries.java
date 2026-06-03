class Solution {
    public ArrayList<Integer> freqInRange(int[] arr, int[][] queries) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], new ArrayList<>());
            }
            map.get(arr[i]).add(i);
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        
        for (int[] q : queries) {
            int l = q[0];
            int r = q[1];
            int x = q[2];
            
            if (!map.containsKey(x)) {
                result.add(0);
                continue;
            }
            
            ArrayList<Integer> indices = map.get(x);
            
            int leftCount = countLessThan(indices, l);
            int rightCount = countLessThan(indices, r + 1);
            
            result.add(rightCount - leftCount);
        }
        
        return result;
    }
    
    private int countLessThan(ArrayList<Integer> list, int target) {
        int idx = Collections.binarySearch(list, target);
        if (idx >= 0) {
            return idx; 
        } else {
            return -idx - 1; 
        }
    }
}