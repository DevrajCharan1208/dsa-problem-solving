class Solution {
    public Queue<Integer> reverseFirstK(Queue<Integer> q, int k) {
        int n = q.size();
        if (k > n || k <= 0) {
            return q;
        }
        Stack<Integer> s = new Stack<>();
        for(int i = 0; i < k; i++){
            s.push(q.remove());
        }
        while(!s.isEmpty()){
            q.add(s.pop());
        }
        for(int i = 0; i < n - k; i++){
            q.add(q.remove());
        }
        return q;
    }
}