class Solution {
    //  public int factorial(int n){
    //         int num=1;
    //         for(int i = n; i>0; i--){
    //             num = num*i;
    //         }
    //       return num;
    //     }
    public int trailingZeroes(int n) {
    //    int fact = factorial(n);
    //    int count = 0;
    //    while(fact%10==0){
    //     count++;
    //     fact= fact/10;
    //    }
    int count = 0;
    // for (int i = 5; n / i >= 1; i *= 5) {
    //     count += n / i;
    // }
    while (n > 0) {
            n = n / 5;
            count += n;
        }
    return count;
    }
}