class Solution {
    public List<String> summaryRanges(int[] nums) {
        int start = 0;
        int end = 1;
        int currNum;
        List<String> ranges = new ArrayList<>();
        int n = nums.length;
        if(n==0)
         return ranges;
       
        while(start<n){
            currNum = nums[start];
            while(end<n && nums[end]==currNum+1){
                currNum = nums[end];
                end++;
            }

            String str = null;
            if (start + 1 == end) {
                str = String.valueOf(nums[start]);
            } else {
                str = nums[start] + "->" + nums[end - 1];
            }
            ranges.add(str);
            start = end;

            end++;
        }
      return ranges;  
    }
}