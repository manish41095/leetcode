class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> nextGreater = new HashMap<>();
        Stack<Integer> stack = new Stack();
        // Best Solution 1
        // for(int num : nums2){
        //     while(!stack.isEmpty() && num > stack.peek()){
        //         nextGreater.put(stack.pop(), num);
        //     }
        //     stack.push(num);
        // }

       // Solution 2 Start
        stack.push(nums2[nums2.length - 1]);
        nextGreater.put(nums2[nums2.length - 1], -1);

        for(int i = nums2.length - 2; i>=0; i--){

            if(nums2[i] < stack.peek()){
                nextGreater.put(nums2[i] , stack.peek());
                stack.push(nums2[i]);
                continue;

            }
            while(!stack.isEmpty() && nums2[i] > stack.peek())
                stack.pop();

            if(stack.isEmpty()){
                stack.push(nums2[i]);
                nextGreater.put(nums2[i], -1);
            }
            else{
               nextGreater.put(nums2[i], stack.peek());
               stack.push(nums2[i]); 
            }
        }
        // Solution 2 end 


        //Common part for both the solution
        int[] res = new int[nums1.length];
        for(int i = 0; i < nums1.length ; i++)
            res[i] = nextGreater.getOrDefault(nums1[i], -1);

         return res;   
        
    }
}