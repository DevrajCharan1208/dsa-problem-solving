class Solution {
    public int minSteps(int[] arr, int start, int end) {
        if (start == end) {
            return 0;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        
        int[] steps = new int[1000];
        Arrays.fill(steps, -1);
        steps[start] = 0;
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            
            for (int multiplier : arr) {
                int nextVal = (int) (((long) current * multiplier) % 1000);
                
                if (nextVal == end) {
                    return steps[current] + 1;
                }
                
                if (steps[nextVal] == -1) {
                    steps[nextVal] = steps[current] + 1;
                    queue.offer(nextVal);
                }
            }
        }
        
        return -1;
    }
}