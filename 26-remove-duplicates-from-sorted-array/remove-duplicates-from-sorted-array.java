class Solution {
    public int removeDuplicates(int[] nums) {

       int counter = 0;
       int n = nums.length;
        for(int i = 0; i < n; i++){
            if(i < n- 1 && nums[i]==nums[i+1])
                continue;
            else
                nums[counter++] = nums[i];    

        }
        return counter;
    }

}