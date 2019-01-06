/*
Given a sorted array of positive numbers in ascending order, 
find the smallest positive integer value that cannot be represented as sum of elements of any sub-sequence of the input array.
*/

the explanation of this brilliant algorithm:
https://stackoverflow.com/questions/21077763/smallest-number-that-can-not-be-formed-from-sum-of-numbers-from-array/21078133#21078133

// 'greedy' is in the tag of this one.
public class Solution {
  public int firstMissing(int[] array) {
    int res = 1;
    for (int i = 0; i < array.length; i++) {
      if (array[i] <= res) {
        res += array[i];
      } else {
        return res;
      }
    }
    return res;
	}
}


// I misunderstood the description at first sight. I misunderstood 'sub-sequence' as 'consecutive subarray'.
// in that way, the code would be like this:

public int firstMissing(int[] array) {
  // use prefix array
  for (int i = 1; i < array.length; i++) {
	  array[i] += array[i - 1];
  }
  return helper(array);
}

private int helper(int[] array) {
	int i = 0;
	int count = 1;
	while (i < array.length) {
		if (array[i] == count) {
			i++;
			count++;
		} else if (array[i] < count) {
			i++;
		} else {
			int j = 0;
			while (array[i] - array[j] > count) {
				j++;
			}
			if (array[i] - array[j] == count) {
				count++;
			} else {
				return count;
			}
		}
	}
	return count;
}
