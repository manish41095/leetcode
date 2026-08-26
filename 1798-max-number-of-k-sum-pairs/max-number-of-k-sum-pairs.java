class Solution {
    public int maxOperations(int[] nums, int k) {
        int n = nums.length;
        // approach1 - two point TC O(nlogn)
        // int i = 0;
        // int j = n-1;
        // int count = 0;
        // Arrays.sort(nums);
        // while(i < j){
        //     int sum = nums[i] + nums[j];
        //     if(sum == k){
        //         i++;
        //         j--;
        //         count++;
        //     }
        //     else if(sum < k){
        //         i++;
        //     }
        //     else{
        //         j--;
        //     }
        // }

        // return count;

        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for(int i = 0 ; i < n ; i++){
          if(map.containsKey(k - nums[i]) && map.get(k - nums[i])!=0){
             count++;
             map.put(k - nums[i], map.get(k - nums[i])-1);
          }
         
          else
          map.put(nums[i], map.getOrDefault(nums[i],0)+1);

        }
        return count;
    }
}