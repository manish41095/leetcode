class Solution {
    public int longestConsecutive(int[] nums) {
        int result = 0;
        Map<Integer, Boolean> map = new HashMap<>();

        for(int num: nums){
            map.put(num,Boolean.FALSE);
        }

        for(int num: nums){
            int currentLenght = 1;
            int nextNum = num + 1;
            while(map.containsKey(nextNum) && map.get(nextNum)==false){
                currentLenght++;
                map.put(nextNum,Boolean.TRUE);
                nextNum++;
            }
            int prevNum = num-1;
            while(map.containsKey(prevNum) && map.get(prevNum)==false){
                currentLenght++;
                map.put(prevNum,Boolean.TRUE);
                prevNum--;
            }
            result = Math.max(result,currentLenght);
       }

       return result;
    }
}