class Solution {
    public int mySqrt(int x) {
        long  l = 0;
        long r = x/2 + 1;
        while(l < r){
            long mid  = l + (r-l)/2 +1;
            long sqre = mid*mid;
            if(sqre == x){
            return (int)mid;
            }
            else if(sqre < x){
                l = mid;
            }
            else{
                r = mid-1;
            }
        }
        return  (int)l ;
    }
}