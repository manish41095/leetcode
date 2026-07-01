class Solution {
    public int hIndex(int[] citations) {
        int len = citations.length;
        int[] arr = new int[len+1];

        for(int num : citations){
            if(num > len )
                arr[len]++;
            else
               arr[num]++;
        }

        int count = 0;

        for(int i = len; i>=0 ; i--){
            count += arr[i];
            if(count>=i)
              return i;
        }
        return 0;
    }
}