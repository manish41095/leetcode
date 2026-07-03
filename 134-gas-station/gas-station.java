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
        
        int currentGas = 0;
        int startIndex = 0;

        for(int i = 0; i < gas.length; i++){
            currentGas += gas[i] - cost[i];
            // if current gas -ve reset the current gas to 0 and reset the start index to next index i.e. i+1
            if(currentGas < 0){
                startIndex = i+1;
                currentGas = 0;
            }
        } 
        return startIndex;
    }
}