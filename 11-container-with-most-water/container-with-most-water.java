class Solution {
    public int maxArea(int[] height) {

        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while(left < right){
            int side = Math.min(height[left], height[right]);
            int area = side * ( right - left);

            if(height[left] < height[right]){
                left++;
            }

            else{
                right--;
            }
            
            
            
            if(area > maxArea)
              maxArea = area;
        }

        return maxArea;
        
    }
}