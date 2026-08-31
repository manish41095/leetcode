class Solution {
    public String frequencySort(String str) {

        //     Map<Character, Integer> map = new HashMap<>();

        //     StringBuilder sb = new StringBuilder();

        //     for(char c : s.toCharArray()){
        //     map.put(c, map.getOrDefault(c,0)+1);
        //     }

        //    // char[] arr = new char[s.length()];
        //     List<Character> arr = new ArrayList<>();

        //     for(char c : s.toCharArray()){
        //      arr.add(c);
        //     }
        //     arr.sort((a,b) -> Integer.compare(map.get(b), map.get(a)));

        //     for(char c : arr)
        //     sb.append(c);

        //     return sb.toString();  

        Map<Character, Integer> freq = new HashMap<>();

        for (char c : str.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        List<Character> chars = new ArrayList<>(freq.keySet());

        // for (char c : str.toCharArray()) {
        //     chars.add(c);
        // }

        chars.sort((a, b) -> Integer.compare(freq.get(b), freq.get(a)));

        StringBuilder result = new StringBuilder();

        for (char c : chars) {
            for (int i = 0; i < freq.get(c); i++) {
                result.append(c);
            }
        }

        return result.toString();

    }
}