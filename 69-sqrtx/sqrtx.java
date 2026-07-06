class Solution {
    public int mySqrt(int x) {
        // long  l = 0;
        // long r = x/2 + 1;
        // while(l < r){
        //     long mid  = l + (r-l)/2 +1;
        //     long sqre = mid*mid;
        //     if(sqre == x){
        //     return (int)mid;
        //     }
        //     else if(sqre < x){
        //         l = mid;
        //     }
        //     else{
        //         r = mid-1;
        //     }
        // }
        // return  (int)l ;
        if(x==0)
        return 0;
        long low =1;
        long high = x;
        long ans = 1;
        while(low <= high){
             long mid = (long) (low+high)/2;
             long sqr = mid*mid;
            if(sqr <= x){
                ans = mid;
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }

        return (int)high;
    }
}