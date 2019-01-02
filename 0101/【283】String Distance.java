/*
Given an array of strings, and two different string s and t. We need to return the smallest indices difference between the two given strings.

Return -1 if we can not find s or t in the array.

Assumptions:

The given array is not null, none of the strings in the array is null.
s and t are different and they are not null.
Examples:

array =  {"this", "is", "a", "is", "fox", "happy"}, the distance of "fox" and "is" is 1.
*/

// O(n)
public class Solution {
  public int distance(String[] array, String source, String target) {
    // hashmap record apperance indices of unique string in array
    Map<String, List<Integer>> map = new HashMap<>();
    for (int i = 0; i < array.length; i++) {
      List<Integer> list = map.get(array[i]);
      if (list == null) {
        List<Integer> l = new ArrayList<>();
        l.add(i);
        map.put(array[i], l);
      } else {
        list.add(i);
        map.put(array[i], list);
      }
    }
    // find the least diff in two lists which are sorted already
    List<Integer> l1 = map.get(source);
    List<Integer> l2 = map.get(target);
    if (l1 != null && l2 != null) {
      int i = l1.size() - 1;
      int j = l2.size() - 1;
      int diff = Integer.MAX_VALUE;
      while (i >= 0 && j >= 0) {
        int val_s = l1.get(i);
        int val_t = l2.get(j);
        if (val_s < val_t) {
          j--;
          diff = Math.min(diff, val_t - val_s);
        } else {
          i--;
          diff = Math.min(diff, val_s - val_t);
        }
      }
      return diff;
    }
    return -1;
  }
}
