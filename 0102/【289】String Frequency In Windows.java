/*
Given a string containing only 'A', 'B', 'C', 'D', return the number of occurrences of substring which has length 4 and includes all of the characters from 'A', 'B', 'C', 'D' with in descending sorted order.

Assumptions:

The given string is not null and has length of >= 4.
In the output, if two substrings have the same frequency, then they should be sorted by the their natural order.
Examples:

 “ABCDABCDD”, --> {"ABCD" : 2, "BCDA" : 1, "CDAB" : 1, "DABC" : 1}
*/

/**
 * public class Frequency {
 *   public String str;
 *   public int freq;
 *   public Frequency(String str, int freq) {
 *     this.str = str;
 *     this.freq = freq;
 *   }
 * }
 */
 
 // common sliding window.
 // map can be optimized to array
public class Solution {
  public List<Frequency> frequency(String input) {
    if (input == null) return new ArrayList<Frequency>();
    Map<Character, Integer> map = createMap();
    int count = 0;
    int left = 0;   
    char[] arr = input.toCharArray();
    Map<String, Integer> res = new HashMap<>();
    for (int i = 0; i < arr.length; i++) {
      if (map.get(arr[i]) > 0) {
        count++;
      }
      map.put(arr[i], map.get(arr[i]) - 1);
      while (count == 4) {
        if (i - left + 1 == 4) {
          if (res.get(input.substring(left, i + 1)) != null) {
            res.put(input.substring(left, i + 1), res.get(input.substring(left, i + 1)) + 1);
          } else {
            res.put(input.substring(left, i + 1), 1);
          }
        }
        if (map.get(arr[left]) + 1 > 0) {
          count--;
        }
        map.put(arr[left], map.get(arr[left]) + 1);
        left++;
      }
    }
    List<Frequency> list = new ArrayList<>();
    for (String s : res.keySet()) {
      list.add(new Frequency(s, res.get(s)));
    }
    Collections.sort(list, new Comparator<Frequency>() {
      @Override
      public int compare(Frequency f1, Frequency f2) {
        if (f1.freq == f2.freq) {
          return f1.str.compareTo(f2.str);
        } else {
          return f1.freq < f2.freq ? 1 : -1;
        }
      }
    });
    return list;
  }
  
  private Map<Character, Integer> createMap() {
		Map<Character, Integer> map = new HashMap<>();
		map.put('A', 1);
		map.put('B', 1);
		map.put('C', 1);
		map.put('D', 1);
		return map;
	}
}

