/*
Determine whether an integer is a palindrome.

Assumptions

Could negative integers be palindromes? (ie, -1) No.

If you are thinking of converting the integer to string, note the restriction of using extra space.
You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", you know that the reversed integer might overflow. 
How would you handle such case? There is a more generic way of solving this problem.
*/

public class Solution {
  public boolean isPalindrome(int x) {
	  if (x < 0) return false;
	  int counter = getMaxCounter(x);
	  while (counter > 0) {
	    if (x < 10) return true;
	    int n1 = x / counter; 	    // highest position
	    int n2 = x % counter % 10;  	    // lowest position
	    if (n1 != n2) return false;
	    x = x % counter / 10;
	    counter /= 100;
	  }
	  return true;
	}
	  
	private int getMaxCounter(int x) {
	  int counter = 1;
    // NOTICE: cannot use 'counter * 10 < x', to avoid int overflow
	  while (counter < x / 10) {
	    counter *= 10;
	  }
	  return counter;
	}
}

/*
1234321 = 1111 * 1111
272  272 % 100 / 10 = 7
37673   37673 % 10000 / 10 = 767
717   717 % 100 / 10 = 1
545 

515 
counter = 100

525
*/
