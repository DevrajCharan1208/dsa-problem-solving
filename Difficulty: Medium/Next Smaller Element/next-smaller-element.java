class Solution {
    static ArrayList<Integer> nextSmallerEle(int[] arr) {
        Stack<Integer> s = new Stack<>();
        ArrayList<Integer> nextSmaller = new ArrayList<>();

        for (int i = arr.length-1;i>=0;i--){

            while(!s.isEmpty()&&arr[i]<=s.peek()){
                s.pop();
            }
            if(s.empty()){
                nextSmaller.add(-1);
            }else{
                nextSmaller.add(s.peek());
            }

            s.push(arr[i]);
        }
        Collections.reverse(nextSmaller);
        return nextSmaller;
        
    }
}