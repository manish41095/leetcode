class Solution {
    public int mySqrt(int x) {
        if (x == 0 || x == 1)
            return x;
        int low = 1;
        int high = x;
        int ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (mid <= x / mid) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }
        return ans;

    }

    // public int mySqrt(int x) {
    //     if(x==0)
    //     return 0;
    //     long low =1;
    //     long high = x;
    //     long ans = 1;
    //     while(low <= high){
    //          long mid = (long) (low+high)/2;
    //          long sqr = mid*mid;
    //         if(sqr <= x){
    //             ans = mid;
    //             low = mid+1;
    //         }
    //         else{
    //             high = mid-1;
    //         }
    //     }

    //     return (int)high;
    // }
}