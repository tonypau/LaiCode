/*
[110]
Consider an unlimited flow of data elements. How do you sample k element from this flow, 
such that at any point during the processing of the flow, you can return a random set of k elements from the n elements read so far. 

Assumptions

k >= 1
You will implement two methods for a sampling class:

read(int value) - read one number from the flow
sample() - return at any time the k samples as a list, return the list of all values read when the number of values read so fas <= k.
You may need to add more fields for the class.
*/

// 又称蓄水池问题
// when counter <= k, put everything in list
// when counter > k, every new element has the probability k / counter to put into the list
public class Solution {
  private final int k;
  private int counter;
  private List<Integer> list;
  
  public Solution(int k) {
    this.k = k;
    this.counter = 0;
    this.list = new ArrayList<>();
  }
  
  public void read(int value) {
    counter++;
    if (counter <= k) {
      list.add(value);
    } else {
    // here r may be the num in [0,1,2,....k....counter - 1]
      int r = (int) (Math.random() * counter);
      // r < k, means ok, let's replace the index r in [0..k] with new element
      if (r < k) {
        list.set(r, value);
      }
    }
  }
  
  public List<Integer> sample() {
    return list;
  }
}

