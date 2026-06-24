class Solution {
    public List<Integer> findDuplicates(int[] nums) {
       int n = nums.length;
    // Method 1 using extra space SC : O(n) , TC: O(n)  
    //    Set<Integer> set = new HashSet<>();
    //    List<Integer> result  = new ArrayList<>();
    //    for(int i = 0 ; i < n ; i ++){
    //     if(set.contains(nums[i])){
    //         result.add(nums[i]);
    //     }
    //     else{
    //         set.add(nums[i]);
    //     }
    //    }
    //    return result;

        List<Integer> result = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            int index = Math.abs(nums[i])-1;

            if(nums[index]<0)
            result.add(index+1);

            nums[index] = nums[index]*(-1);
        }
        return result;
    }
}