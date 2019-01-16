public class Solution {
  public String hex(int number) {
    if (number == 0) return "0x0";
    String res = "";
    while (number != 0) {
      int num = number % 16;
      if (num >= 10) {
        res += (char)(num - 10 + 'A');
      } else {
        res += num;
      }
      number /= 16;
    }
    StringBuilder builder = new StringBuilder(res);
    return "0x" + builder.reverse().toString();
  }
}

