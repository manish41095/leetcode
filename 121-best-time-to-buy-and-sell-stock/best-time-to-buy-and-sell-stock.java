class Solution {
    public int maxProfit(int[] prices) {

        int buyPrice = prices[0];
        int maxProfit = 0;
        
        for(int i = 1; i < prices.length ; i++){
           int currProfit = prices[i] - buyPrice;

           if(currProfit > maxProfit)
              maxProfit = currProfit;

           if(buyPrice > prices[i])
             buyPrice =  prices[i];
        }
        return maxProfit;
    }
}