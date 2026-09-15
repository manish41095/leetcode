class Solution {

    public int[] countBits(int n) {
        int[] res = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            // i >> 1 is the same as i / 2
            // i & 1 is the same as i % 2
            res[i] = res[i >> 1] + (i & 1);
        }
        return res;
    }

    //Approach1 
    // public int[] countBits(int n) {

    //     int[] res = new int[n + 1];
    //     res[0] = 0;
    //     if (n == 0)
    //         return res;

    //     res[1] = 1;

    //     for (int i = 2; i <= n; i++)
    //         res[i] = count(i);

    //     return res;

    // }

    // public int count(int n) {
    //     int count = 0;

    //     while (n > 0) {
    //         int rem = n % 2;
    //         if (rem == 1)
    //             count++;
    //         n = n / 2;
    //     }

    //     return count;
    // }
}