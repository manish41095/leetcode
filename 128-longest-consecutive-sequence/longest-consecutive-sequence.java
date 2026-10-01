class Solution {
    public int longestConsecutive(int[] nums) {
        //Revision 01-10-2026
        // Build the set to achieve O(1) lookups
        Set<Integer> set = new HashSet<>();

        int maxLen = 0;
        for (int num : nums) {
            set.add(num);
        }

        for (int num : set) {
            // A number is a sequence start when num - 1 is absent.
            if (!set.contains(num - 1)) {
                int currLen = 1;
                int current = num;
                // Expand the sequence forward
                while (set.contains(current + 1)) {
                    currLen++;
                    current++;
                }
                maxLen = Math.max(maxLen, currLen);
            }
        }

        return maxLen;
    }

    //  int result = 0;
    //     Map<Integer, Boolean> map = new HashMap<>();

    //     for(int num: nums){
    //         map.put(num,Boolean.FALSE);
    //     }

    //     for(int num: nums){
    //         int currentLenght = 1;

    //         //Check consecutive num greater than current num
    //         int nextNum = num + 1;
    //         while(map.containsKey(nextNum) && map.get(nextNum)==false){
    //             currentLenght++;
    //             map.put(nextNum,Boolean.TRUE);
    //             nextNum++;
    //         }

    //          //Check consecutive num less than current num
    //         int prevNum = num-1;
    //         while(map.containsKey(prevNum) && map.get(prevNum)==false){
    //             currentLenght++;
    //             map.put(prevNum,Boolean.TRUE);
    //             prevNum--;
    //         }
    //         result = Math.max(result,currentLenght);
    //    }

    //    return result;   
}