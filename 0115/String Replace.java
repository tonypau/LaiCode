public class Solution {
  public String replace(String input, String source, String target) {
    if (input.length() == 0 || source.length() == 0 || input.length() < source.length()) return input;
    char[] arr = input.toCharArray();
    char[] s = source.toCharArray();
    char[] t = target.toCharArray();
    if (source.length() < target.length()) {
      return replaceWithLongerOne(arr, s, t);
    } else {
      return replaceWithShorterOne(arr, s, t);
    }
  }
  
  private String replaceWithLongerOne(char[] arr, char[] s, char[] t) {
    Set<Integer> matchIndex = getMatch(arr, s);
    char[] newArr = new char[arr.length + matchIndex.size() * (t.length - s.length)];
    int slow = newArr.length - 1;
    int fast = arr.length - 1;
    while (fast >= 0) {
      if (matchIndex.contains(fast - s.length + 1)) {
        change(newArr, t, slow - t.length + 1);
        slow -= t.length;
        fast -= s.length;
      } else {
        newArr[slow--] = arr[fast--];
      }
    }
    return new String(newArr);
  }
  
  private String replaceWithShorterOne(char[] arr, char[] s, char[] t) {
    Set<Integer> matchIndex = getMatch(arr, s);
    int slow = 0;
    int fast = 0;
    while (fast < arr.length) {
      if (matchIndex.contains(fast)) {
        change(arr, t, slow);
        slow += t.length;
        fast += s.length;
      } else {
        arr[slow++] = arr[fast++];
      }
    }
    return new String(arr, 0, slow);
  }
  
  private Set<Integer> getMatch(char[] arr, char[] s) {
    Set<Integer> set = new HashSet<>();
    int i = 0;
    while (i <= arr.length - s.length) {
      if (isMatch(arr, s, i)) {
        set.add(i);
        i += s.length;
      } else {
        i++;
      }
    }
    return set;
  }
  
  private boolean isMatch(char[] arr, char[] s, int index) {
    for (int i = 0; i < s.length; i++) {
      if (s[i] != arr[index + i]) {
        return false;
      }
    }
    return true;
  }
  
  private void change(char[] arr, char[] t, int startIndex) {
    for (int i = 0; i < t.length; i++) {
      arr[startIndex + i] = t[i];
    }
  }
}

