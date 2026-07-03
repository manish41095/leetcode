class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;

        for(int i = 0; i < gas.length; i++){
            totalGas += gas[i];
            totalCost +=cost[i]; 
        }

        if(totalGas < totalCost)
            return -1;
        
        int currentCost = 0;
        int startIndex = 0;

        for(int i = 0; i < gas.length; i++){
            currentCost += gas[i] - cost[i];
            // if current cost -ve reset the current cost to 0 and reset the start index to next index i.e. i+1
            if(currentCost < 0){
                startIndex = i+1;
                currentCost = 0;
            }
        } 
        return startIndex;
    }
}