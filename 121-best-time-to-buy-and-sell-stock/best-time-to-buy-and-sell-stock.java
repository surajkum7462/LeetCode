class Solution {
    public int maxProfit(int[] prices) {
      int price=0;
      int minPrice = Integer.MAX_VALUE;
      for(int num : prices)
      {
         if(num < minPrice)
         {
            minPrice=num;
         }
         price = Math.max(price,num-minPrice);
      }
      return price;
    }
}