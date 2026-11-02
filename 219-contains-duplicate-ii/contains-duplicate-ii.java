class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {

       Map<Integer, Integer> map = new HashMap<>();

       for(int i=0 ; i < nums.length; i++){
        int num = nums[i];
        if(!map.containsKey(num))
            map.put(num,i);
        else{
            int index = map.get(num);
            int diff =  i - index;
            if(Math.abs(diff) <= k)
                return true;
            else
              map.put(num,i);    
        }    
       }

       return false;
    }
}