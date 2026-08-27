class Solution {
    public int largestAltitude(int[] gain) {
        int max = 0;
        int n = gain.length;
        int highestGain = 0;

        for(int i = 0 ; i < n ; i++){
            highestGain += gain[i];
            max = Math.max(max,highestGain);
        }
        if(max < 0)
            return 0;
        else
            return max;    
        
    }
}