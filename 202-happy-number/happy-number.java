class Solution {
    public boolean isHappy(int n) {
        //Approach 1 with extra space where sum of the digit store in set if number became 1 or number repeated exit from the loop and return the result
        // Set<Integer> seenNumber = new HashSet<>();
        // while (n != 1 && !seenNumber.contains(n)) {
        //     seenNumber.add(n);
        //     n = getSumofSquareOfDigit(n);
        // }
        int slow = n;
        int fast = getSumofSquareOfDigit(n);
        while(fast != 1 && slow != fast){
            slow = getSumofSquareOfDigit(slow);
            fast = getSumofSquareOfDigit(getSumofSquareOfDigit(fast));
        }
        return fast == 1;
    }

    public int getSumofSquareOfDigit(int n){
        int sum = 0;
        while(n>0){
            int digit = n%10;
            sum += digit*digit;
            n /=10;
        }
        return sum;
    }
}