class Solution {
    public int activitySelection(int[] start, int[] end) {
         int[][] activities = new int[start.length][2];
        for(int i = 0; i<start.length; i++){
            activities [i][0] = start[i];
            activities [i][1] = end[i];
        }
        Arrays.sort(activities,Comparator.comparingDouble(o -> o[1]));
        

        int count = 1;
        int curr_end = activities[0][1];
        for(int i = 0; i<start.length;i++){
            if(activities[i][0]>curr_end){
                count++;
                curr_end = activities[i][1];
            }
        }
        return count;
        
    }
}
