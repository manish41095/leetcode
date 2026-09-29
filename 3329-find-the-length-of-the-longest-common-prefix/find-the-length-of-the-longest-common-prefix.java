class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {

        Set<Integer> prefix = new HashSet<>();

        for(int val : arr1){
            while(val > 0){
                prefix.add(val);
                val = val / 10;
            }
        }

        int maxLength = 0;

        for(int val : arr2){

            while(val > 0){
                if(prefix.contains(val)){
                    int currLength = String.valueOf(val).length();
                    maxLength = Math.max(currLength, maxLength);
                    break;
                }
                val = val / 10 ;
            }
        }

        return maxLength;
        
    }
}