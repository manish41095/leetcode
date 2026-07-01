class Solution {
    public int hIndex(int[] citations) {
        int len = citations.length;
        int[] arr = new int[len+1];
        // cit  = [3,0,4,5] - len = 4
        //arr = [0,0,0,0,0]
        for(int num : citations){
            if(num > len )
                arr[len]++;
            else
               arr[num]++;
        }
        // arr = [1,0,0,1,1+1] = [1,0,0,1,2]
        int count = 0;

        for(int i = len; i>=0 ; i--){
            count += arr[i]; // at index len-1 : count = 2+1 = 3
            if(count>=i)    // count >=i bcz i = 3 so it return 3 as the ans for this example
              return i;
        }
        return 0;
    }
}