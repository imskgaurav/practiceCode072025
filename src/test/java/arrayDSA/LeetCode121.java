package test.java.arrayDSA;

import java.util.Arrays;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
public class LeetCode121 {

    public static void main(String[] args) {
        int [] prices = {7,1,5,3,6,4};
        System.out.println("Array is "+Arrays.toString(prices));
        // Assume that 1st Index price is ur Buying price and profit var is 0
        int buyPrice= prices[0];
        int profit=0;

        for(int i=1; i<prices.length; i++){
            //Find minimum buying price
           if (buyPrice>prices[i]){
               buyPrice= prices[i];
            }
           profit = Math.max(profit, prices[i]-buyPrice);
            System.out.println("selling price:"+prices[i]);
        }
        System.out.println("Buying price:"+buyPrice);
        System.out.println(" max Profit is :"+profit);
    }
}
