public class Solution {
  public int minDifference(int[] array) {
    if (array == null || array.length < 2) return -1;
    int[] min = new int[] {Integer.MAX_VALUE};
    int sum = 0;
    for (int i : array) sum += i;
    int[] curSum = new int[1];
    List<Integer> list = new ArrayList<>();
    helper(curSum, list, array, 0, array.length, min, sum);
    return min[0];
  }
  
  private void helper(int[] curSum, List<Integer> list, int[] array, int index, int length, int[] min, int sum) {
    if (index == length) return;
    if (list.size() == length / 2) {
      min[0] = Math.min(min[0], Math.abs(sum - curSum[0] - curSum[0]));
      return;
    }
    curSum[0] += array[index];
    list.add(array[index]);
    helper(curSum, list, array, index + 1, length, min, sum);
    list.remove(list.size() - 1);
    curSum[0] -= array[index];
    helper(curSum, list, array, index + 1, length, min, sum);
  }
}

