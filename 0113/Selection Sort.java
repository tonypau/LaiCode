public class Solution {
  public int[] solve(int[] array) {
    if (array == null || array.length == 0) return array;
    // for each ith position, we find the correct element (the least one behind) from the former sublists
    for (int i = 0; i < array.length; i++) {
      int global_min = i;      
      for (int j = i + 1; j < array.length; j++) {
        if (array[j] < array[global_min]) {
          global_min = j;
        }
      }
      swap(array, i, global_min);
    }
    return array;
  }
  
  private void swap(int[] array, int i, int j) {
    int tmp = array[i];
    array[i] = array[j];
    array[j] = tmp;
  }
}

