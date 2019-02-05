// Recursion, when find array[mid] == target, we do binary search each sides
public class Solution {
  public int totalOccurrence(int[] array, int target) {
    if (array == null || array.length == 0) return 0;
    return helper(array, 0, array.length - 1, target);
  }
  
  private int helper(int[] array, int left, int right, int target) {
    if (left > right) {
      return 0;
    }
    if (left == right && array[left] == target) {
      return 1;
    }
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (array[mid] == target) {
        return 1 + helper(array, left, mid - 1, target) + helper(array, mid + 1, right, target);
      } else if (array[mid] < target) {
        return helper(array, mid + 1, right, target);
      } else {
        return helper(array, left, mid - 1, target);
      }
    }
    return 0;
  }
}

// or find first occurrence and last occurrence respectively
public class Solution {
  public int totalOccurrence(int[] array, int target) {
    if (array == null || array.length == 0) return 0;
    int first = firstOccurrence(array, target);
    if (first == -1) return 0;
    int last = lastOccurrence(array, target);
    return last - first + 1;
  }
  
  // NOTE right index的移动规则，为了代码简洁，当array[mid] > target时，right = mid而不是right = mid - 1
  // 这样做的好处是可以省去loop之后，right为-1的判断
  private int firstOccurrence(int[] array, int target) {
    int left = 0;
    int right = array.length - 1;
    while (left < right) {
      int mid = left + (right - left) / 2;
      if (array[mid] < target) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }
    return array[right] == target ? right : -1;
  }
  
  // 同样，这里的left right的判断也有讲究
  // 因为当while循环到LR连着的情况时，L有可能一直呆在M上，所以while的判断条件是L<R-1
  // 所以在循环结束后要多加判断
  private int lastOccurrence(int[] array, int target) {
    int left = 0;
    int right = array.length - 1;
    while (left < right - 1) {
      int mid = left + (right - left) / 2;
      if (array[mid] == target) {
        left = mid;
      } else if (array[mid] < target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return array[right] == target ? right : (array[left] == target ? left : -1);
  }
}
