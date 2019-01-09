/*
[509]
You are playing the following Flip Game with your friend: Given a string that contains only these two characters: + and -, you and your friend take turns to flip two consecutive "++" into "--". The game ends when a person can no longer make a move and therefore the other person will be the winner.

Write a function to compute all possible states of the string after one valid move.

For example, given s = "++++", after one move, it may become one of the following states:

[
  "--++",
  "+--+",
  "++--"
]
If there is no valid move, return an empty list [].
*/

public class Solution {
  public List<String> generatePossibleNextMoves(String input) {
    List<String> res = new ArrayList<>();
    if (input == null) return res;
    List<Integer> list = scan(input);
    for (int i : list) {
      res.add(input.substring(0, i) + "--" + input.substring(i + 2));
    }
    return res;
  }
  
  private List<Integer> scan(String input) {
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < input.length() - 1; i++) {
      if (input.charAt(i) == '+' && input.charAt(i) == input.charAt(i + 1)) list.add(i);
    }
    return list;
  }
}

