class Solution {
    public int[] twoSum(int[] nums, int target) {

    //Revision 01-10-2026
      int[] ans = new int[2];
      Map<Integer, Integer> map = new HashMap<>();
      for(int i = 0; i < nums.length; i++){

        if(map.containsKey(target - nums[i])){
            ans[0] = i;
            ans[1] = map.get(target - nums[i]);
        }

        map.put(nums[i], i);
      }

      return ans;
    }


    //  int[] result = new int[2];
    //     Map<Integer, Integer> indexMap = new HashMap<>();
    //     for(int i = 0 ; i< nums.length; i++){
    //         int num = nums[i]; 
    //         if( indexMap.containsKey(target-num)){
    //             result[0] = i;
    //             result[1] = indexMap.get(target-num);
    //             break;
    //         }
    //         indexMap.put(num,i);
    //     }
    //    return result;  
}