class Solution {
    public boolean isHappy(int n) {
        Set<Integer> seenNumber = new HashSet<>();
        while(n!=1 && !seenNumber.contains(n)){
            seenNumber.add(n);
            n = getSumofSquareOfDigit(n);
        }
        return n==1;
    }

    public int getSumofSquareOfDigit(int n){
        int sum = 0;
        while(n>0){
            int digit = n%10;
            sum += digit*digit;
            n = n/10;
        }
        return sum;
    }
}