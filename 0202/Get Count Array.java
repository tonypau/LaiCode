// O(nlogn)
public class Solution {
  public int[] countArray(int[] array) {
    // record index to maintain the order. this can save us from using hashtable
    int[] indexArr = new int[array.length];
    for (int i = 0; i < array.length; i++) {
      indexArr[i] = i;
    }
    // return array
    int[] countArr = new int[array.length];
    // 
    int[] helper = new int[array.length];
    mergeSort(helper, countArr, indexArr, array, 0, array.length - 1);
    return countArr;
  }
  
  private void mergeSort(int[] helper, int[] countArr, int[] indexArr, int[] array, int left, int right) {
    if (right <= left) {
      return;
    }
    int mid = left + (right - left) / 2;
    mergeSort(helper, countArr, indexArr, array, left, mid);
    mergeSort(helper, countArr, indexArr, array, mid + 1, right);
    merge(helper, countArr, indexArr, array, left, mid, mid + 1, right);
  }
  
  private void merge(int[] helper, int[] countArr, int[] indexArr, int[] array, int leftL, int rightL, int leftR, int rightR) {
    for (int i = leftL; i <= rightR; i++) {
      helper[i] = indexArr[i];
    }
    int start = leftL;
    while (leftL <= rightL && leftR <= rightR) {
      if (array[helper[leftL]] <= array[helper[leftR]]) {
        countArr[helper[leftL]] += start - leftL;
        indexArr[start++] = helper[leftL++];
      } else {
        indexArr[start++] = helper[leftR++];
      }
    }
    while (leftL <= rightL) {
      countArr[helper[leftL]] += start - leftL;
      indexArr[start++] = helper[leftL++];
    }
  }
}





//     A = { 6   1            8   2   }
//                               start
//                   leftL        leftR
/*           1   6(1)         2   8(1)

             1   2           6(2)  8(1)
  
  helper[leftL].count += start - leftL;


*/
//     B = { 3   0   1   0 }
//
//
