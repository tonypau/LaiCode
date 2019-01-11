/*
[109]
Consider an unlimited flow of data elements. How do you sample k element from this flow, 
such that at any point during the processing of the flow, you can return a random set of k elements from the n elements read so far. 

Assumptions

k >= 1
You will implement two methods for a sampling class:

read(int value) - read one number from the flow
sample() - return at any time the k samples as a list, return the list of all values read when the number of values read so fas <= k.
You may need to add more fields for the class.
*/

public class Solution {
  private Integer sample;
  private int counter;
    
  public Solution() {
    this.counter = 0;
    this.sample = null;
  }
  
  public void read(int value) {
    counter++;
    int r = (int)(Math.random() * counter);
    if (r == 0) {
      sample = value;
    }
  }
  
  public Integer sample() {
    return sample;
  }
}

