class Solution {
    public double fractionalKnapsack(int[] value, int[] weight, int capacity){

        double[][] ratio = new double[value.length][3];

        for(int i = 0; i<value.length;i++){
            ratio[i][0] = (double)value[i]/weight[i];
            ratio[i][1] = value[i];
            ratio[i][2] = weight[i];
        }

        Arrays.sort(ratio, Comparator.comparingDouble(o->o[0]));

        double maxValue = 0;
        for(int i = value.length-1; i>=0;i--){
            if(capacity==0){
                break;
            }
            if((int)ratio[i][2]<=capacity){
                capacity -= ratio[i][2];
                maxValue += ratio[i][1];
            }else{
                maxValue += capacity*ratio[i][0];
                capacity = 0;
            }
        }
        return maxValue;
    }
}