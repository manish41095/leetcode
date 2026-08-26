class Solution {
    public int maxVowels(String s, int k) {
        int vowelCount = 0;
        int maxCount = 0;
      
        for(int i = 0 ; i < k ; i++)
             if(isVowel(s.charAt(i)))
                 vowelCount++;
        

    maxCount=vowelCount;

    for(int i = k; i <s.length();i++){
            if(isVowel(s.charAt(i)))
                vowelCount++;
            
            if(isVowel(s.charAt(i - k)))
                vowelCount--;
            
            maxCount = Math.max(vowelCount, maxCount);
        }

    return maxCount;

    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}