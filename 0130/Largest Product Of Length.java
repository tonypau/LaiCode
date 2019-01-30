public class Solution {
  public int largestProduct(String[] dict) {
    Map<String, Integer> map = new HashMap<>();
    for (String s : dict) {
      int num = 0;
      for (int i = 0; i < s.length(); i++) {
        num |= 1 << s.charAt(i) - '0';
      }
      map.put(s, num);
    }
    Arrays.sort(dict, new Comparator<String>() {
      @Override
      public int compare(String s1, String s2) {
        if (s1.length() == s2.length()) {
          return 0;
        }
        return s1.length() < s2.length() ? 1 : -1;
      }
    });
    int max = 0;
    for (int i = 0; i < dict.length; i++) {
      for (int j = i + 1; j < dict.length; j++) {
        if (dict[i].length() * dict[j].length() <= max) {
          break;
        }
        int num1 = map.get(dict[i]);
        int num2 = map.get(dict[j]);
        if ((num1 & num2) == 0) {
          max = dict[i].length() * dict[j].length();
        }
      }
    }
    return max;
  }
}
