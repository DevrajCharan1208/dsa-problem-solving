
class Solution {
    public int minInsAndDel(int[] a, int[] b) {
        int n = a.length;
        int m = b.length;
        
        HashSet<Integer> setB = new HashSet<>();
        for (int val : b) {
            setB.add(val);
        }
        
        ArrayList<Integer> filtered = new ArrayList<>();
        for (int val : a) {
            if (setB.contains(val)) {
                filtered.add(val);
            }
        }
        
        ArrayList<Integer> lis = new ArrayList<>();
        for (int val : filtered) {
            int idx = binarySearchInB(b, val);
            
            int pos = Collections.binarySearch(lis, idx);
            if (pos < 0) {
                pos = -(pos + 1);
            }
            
            if (pos == lis.size()) {
                lis.add(idx);
            } else {
                lis.set(pos, idx);
            }
        }
        
        int lcsLength = lis.size();
        return (n - lcsLength) + (m - lcsLength);
    }
    
    private int binarySearchInB(int[] b, int target) {
        int low = 0, high = b.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (b[mid] == target) {
                return mid;
            } else if (b[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}