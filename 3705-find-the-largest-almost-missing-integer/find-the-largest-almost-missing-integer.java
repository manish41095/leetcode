class Solution {
    public int largestInteger(int[] nums, int k) {
        // Approach1
        // int[] count = new int[51];
        // int n = nums.length;

        // for(int i = 0 ; i <= n-k ; i++){
        //     boolean[] seen = new boolean[51];
        //     for(int j = i ; j < i+ k ; j++){
        //         if(!seen[nums[j]]){
        //         count[nums[j]]++;
        //         seen[nums[j]] = true;
        //         }
        //     }
        // } 

        // int ans = -1;
        // for(int x = 0 ; x < count.length; x++){
        //     if(count[x] == 1)
        //     ans = x;
        // }

        // return ans;

        //Approach 2

        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);

        if (k == 1) {
            int max = -1;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() == 1) {
                    max = Math.max(max, entry.getKey());
                }
            }
            return max;
        }

        // One subarray of size n so we need to find max element in the array
        //if any element appear more than one time in same sub array that will not be conidered
        //two  apperance its conside only one apperance it will conside two only if it 
        //appear   in two different sub array
        if (k == n) {
            int max = -1;
            for (int num : nums)
                max = Math.max(max, num);

            return max;
        }

        // 2 < k > n
        // In this case one first and last element have chance to appear only once rest of
        // element will appear more than one time in k length of sub array.

        int firstNum = nums[0];
        int lastNum = nums[n-1];
        int firstCount = 0;
        int lastCount = 0;
        int max = -1;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getKey() == firstNum)
               firstCount = entry.getValue();
             if(entry.getKey() == lastNum)
               lastCount = entry.getValue(); 

             if(firstCount == 1)
               max = Math.max(firstNum, max);   

              if(lastCount == 1)
               max = Math.max(lastNum, max);      
        }

        return max;

    }
}