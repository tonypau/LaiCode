// tc:O(n)
// sc:O(n)
public class Solution {
  public List<List<Integer>> allPairs(int[] array, int target) {
    List<List<Integer>> res = new ArrayList<>();
    Map<Integer, List<Integer>> map = new HashMap<>();
    for (int i = 0; i < array.length; i++) {
      if (map.containsKey(target - array[i])) {
        for (Integer j : map.get(target - array[i])) {
          res.add(Arrays.asList(j, i));
        }
      }
      List<Integer> list = map.get(array[i]);
      if (list == null) {
        list = new ArrayList<Integer>();
      }
      list.add(i);
      map.put(array[i], list);
    }
    return res;
  }
}

