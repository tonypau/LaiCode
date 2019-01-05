/*
Given an array of numbers in string type, sort them in a way that the concatenation of them yields the largest value. Return the largest number in string type.

Assumptions:

The given array is not null.
Each of the strings in the array is not null and they are all numbers.
Examples:

{“54”, “546”, “648”, “88”}, the arrangement “8864854654” gives the largest value. 
*/


public class Solution {
  static class newComparator implements Comparator<String> {
	    public int compare(String s1, String s2) {
	      int counter = s1.length() < s2.length() ? s1.length() : s2.length();
	      int i = 0;
	      while (i < counter) {
	        if (s1.charAt(i) < s2.charAt(i)) {
	          return 1;
	        } else if (s1.charAt(i) > s2.charAt(i)) {
	          return -1;
	        } else {
	          i++;
	        }
	      }
        int j = 0;
	      while (i < s1.length()) {
          if (j >= s2.length()) j = s2.length() - 1;
	        if (s1.charAt(i) == s2.charAt(j)) {
	        	i++;
            j++;
	        } else if (s1.charAt(i) < s2.charAt(j)) {
	        	return 1;
	        } else {
	        	return -1;
	        }
	      }
	      while  (i < s2.length()) {
	    	  if (j >= s1.length()) j = s1.length() - 1;
		      if (s2.charAt(i) == s1.charAt(j)) {
		        i++;
            j++;
		      } else if (s2.charAt(i) < s1.charAt(j)) {
		        return -1;
		      } else {
		        return 1;
		      }
		    }
	      return 0;
	    }
	  }
	  
	  public String largestNumber(String[] input) {
	    Arrays.sort(input, new newComparator());
	    String res = "";
	    for (String s : input) {
	      res += s;
	    }
	    return res;
	  }
}

