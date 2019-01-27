public class Solution {
  static class Element {
    int value;
    List<Integer> comparedValues;
    Element(int value) {
      this.value = value;
      this.comparedValues = new ArrayList<>();
    }
  }
  
  public int[] largestAndSecond(int[] array) {
    Element[] arr = new Element[array.length];
    for (int i = 0; i < array.length; i++) {
      arr[i] = new Element(array[i]);
    }
    int len = arr.length;
    while (len > 1) {
      for (int i = 0; i < len / 2; i++) {
        if (arr[i].value < arr[len - i - 1].value) {
          swap(arr, i, len - i - 1);
        }
        arr[i].comparedValues.add(arr[len - i - 1].value);
      }
      len = (len + 1) / 2; //很关键，如果只是/2，会导致奇数长的array漏掉中间element
    }
    return new int[]{arr[0].value, largest(arr[0].comparedValues)};
  }
  
  private int largest(List<Integer> list) {
    int max = list.get(0);
    for (int num : list) {
      max = Math.max(max, num);
    }
    return max;
  }
  
  private void swap(Element[] nums, int i, int j) {
    Element tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }
}
