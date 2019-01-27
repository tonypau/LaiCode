public class Solution {
  public List<List<Integer>> allPairs(int[] array, int target) {
    Map<Integer, List<Integer>> map = new HashMap<>();
    List<List<Integer>> res = new ArrayList<>();
    for (int i = 0; i < array.length; i++) {
      if (map.containsKey(target - array[i])) {
        for (int j : map.get(target - array[i])) {
          res.add(Arrays.asList(j, i));
        }
      }
      List<Integer> list = map.get(array[i]);
      if (list == null) {
        list = new ArrayList<>();
      }
      list.add(i);
      map.put(array[i], list);
    }
    return res;
  }
}

