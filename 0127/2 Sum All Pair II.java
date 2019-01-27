public class Solution {
  public List<List<Integer>> allPairs(int[] array, int target) {
    List<List<Integer>> res = new ArrayList<>();
    Map<Integer, Boolean> map = new HashMap<>();
    for (int i = 0; i < array.length; i++) {
      if (map.containsKey(target - array[i]) && !map.get(target - array[i])) {
        res.add(Arrays.asList(target - array[i], array[i]));
        map.put(target - array[i], true);
        map.put(array[i], true);
      }
      if (!map.containsKey(array[i])) {
        map.put(array[i], false);
      }
    }
    return res;
  }
}

