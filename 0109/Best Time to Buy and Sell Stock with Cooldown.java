/*
[421]
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. 
You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:

You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
Example:

prices = [1, 2, 3, 0, 2]
maxProfit = 3
transactions = [buy, sell, cooldown, buy, sell]
*/

// FSM: finite state machine
// we have three different states in this problem.
// in state0, we have no stocks in hand. what we can do is buy a stock into state1, or rest (cooldown) still into state0
// in state1, we have stock in hand. what we can do is sell it into state2, or rest (cooldown) still into state1
// in state2, we have just sold stock. what we can only do is rest into state0. because we must rest a day after selling
//         notice why not back into state2 after rest in state2. because state2 must be the state after selling

// s0[i] = max(s2[i - 1], s0[i - 1])   the state0 comes from two ways.
// s1[i] = max(s1[i - 1], s0[i - 1] - prices[i])     the state1 comes from two ways
// s2[i] = s1[i - 1] + prices[i]    state2 comes from one way

public class Solution {
  public int maxProfit(int[] prices) {
    if (prices == null || prices.length == 0) {
      return 0;
    }
    int[] s0 = new int[prices.length];
    int[] s1 = new int[prices.length];
    int[] s2 = new int[prices.length];
    s0[0] = 0;  // at first, we have no stocks. the balance is 0
    s1[0] = -prices[0];     // state1 must be the state after buying. so the balance in 0th position must be 0 - prices[0]
    s2[0] = Integer.MIN_VALUE;   // before s2[0], no states exist, just set a lower base case
    for (int i = 1; i < prices.length; i++) {
      s0[i] = Math.max(s2[i - 1], s0[i - 1]);
      s1[i] = Math.max(s1[i - 1], s0[i - 1] - prices[i]);
      s2[i] = s1[i - 1] + prices[i];
    }
    return Math.max(s0[s0.length - 1], s2[s2.length - 1]);
  }
}
