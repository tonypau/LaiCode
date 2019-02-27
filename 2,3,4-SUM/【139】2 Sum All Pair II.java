// tc: O(n)
// sc: O(n)

// data structure: map: num-whether added into res
// init: /
// for each step:
//    case1: if current element is not in map, add into it with false
//    case2: if current element has been in map:
//       case2.1: target-num is also in map and target-num has not been added into result, add into result and set the two false
//       case2.2: target-num is also in map and target-num has been added into result, ignore
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

