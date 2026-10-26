class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        // XOR every number in the array
        for (int num : nums)
            ans ^= num;

        return ans;

    }
}