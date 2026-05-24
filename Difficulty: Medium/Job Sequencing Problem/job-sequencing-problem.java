/*
struct Job
{
   int id;	 // Job Id
   int deadline; // Deadline of job
   int profit; // Profit if job is over before or on deadline
};
*/
class Solution {
    int[] JobScheduling(Job jobs[], int n) {
        Arrays.sort(jobs, (a,b) -> b.profit-a.profit);
        int[] result = {0,0};
        boolean[] time = new boolean[n+1];


        for(int i = 0; i<n; i++){
            for (int j = jobs[i].deadline; j > 0; j--) {
                if (!time[j]) { // Found an available slot!
                    time[j] = true; // Book the slot
                    result[0]++; result[1]+=jobs[i].profit;
                    break; // Move on to the next job
                }
            }
            // if(!time[jobs[i].deadline]){
            //     result[0]++; result[1]+=jobs[i].profit;
            //     time[jobs[i].deadline] = true;
            // }
        }
        return result;
    }
}