/*
Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 231 - 1.

For example,

123 -> "One Hundred Twenty Three"
12345 -> "Twelve Thousand Three Hundred Forty Five"
1234567 -> "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
*/

public class Solution {
  private static final Map<Character, List<String>> myMap = createMap();
	private static Map<Character, List<String>> createMap() {
		Map<Character, List<String>> myMap = new HashMap<>();
    		myMap.put('0', Arrays.asList("Zero"));
		myMap.put('1', Arrays.asList("One"));
		myMap.put('2', Arrays.asList("Two", "Twenty"));
		myMap.put('3', Arrays.asList("Three", "Thirty"));
		myMap.put('4', Arrays.asList("Four", "Forty"));
		myMap.put('5', Arrays.asList("Five", "Fifty"));
		myMap.put('6', Arrays.asList("Six", "Sixty"));
		myMap.put('7', Arrays.asList("Seven", "Seventy"));
		myMap.put('8', Arrays.asList("Eight", "Eighty"));
		myMap.put('9', Arrays.asList("Nine", "Ninty"));
		return myMap;
	}
	
	private static final Map<String, String> myMap2 = createMap2();
	private static Map<String, String> createMap2() {
		Map<String, String> myMap2 = new HashMap<>();
		myMap2.put("10", "Ten");
		myMap2.put("11", "Eleven");
		myMap2.put("12", "Twelve");
		myMap2.put("13", "Thirteen");
		myMap2.put("14", "Fourteen");
		myMap2.put("15", "Fifteen");
		myMap2.put("16", "Sixteen");
		myMap2.put("17", "Seventeen");
		myMap2.put("18", "Eighteen");
		myMap2.put("19", "Ninteen");
		return myMap2;
	}

	private static final List<String> list = Arrays.asList("Hundred", "", "Thousand", "Million", "Billion");

	public String numberToWords(int num) {
	    if (num == 0) return "Zero";
		String numString = convert(num); // add ','
		List<String> res = new ArrayList<>();
		int i = numString.length() - 1;
		int carry = 0;
		while (i >= 0) {
			res.add(convertToString(numString, i - 2, i, carry));
			carry++;
			i -= 4;
		}
		Collections.reverse(res);
		String result = "";
		for (String s : res) {
			result += s;
		}
		return result.substring(0, result.length() - 2);
	}

	private String convert(int num) {
		String string = String.valueOf(num);
		char[] arr = new char[string.length() + (string.length() - 1) / 3];
		int slow = arr.length - 1;
		int fast = string.length() - 1;
		int count = 0;
		while (fast >= 0) {
			if (count == 3) {
				count = 0;
				arr[slow--] = ',';
			} else {
				count++;
				arr[slow--] = string.charAt(fast--);
			}
		}
		return new String(arr);
	}

	private String convertToString(String string, int s, int e, int carry) {
		String res = "";
		int i = 0;  // weishu
		while (s <= e) {
			if (s < 0) {
				s++;
				i++;
				continue;
			}
			char cur = string.charAt(s);
			if (cur == '0') {
				i++;
        			s++;
			        continue;
			} else if (i == 1) {
				if (cur == '1') {
					res += myMap2.get(string.substring(s, s + 2)) + " ";
					break;
				} else {
					res += myMap.get(cur).get(1) + " ";
				}
			} else if (i == 2) {
				res += myMap.get(cur).get(0) + " ";
			} else {
				res += myMap.get(cur).get(0) + " " + list.get(0) + " "; 
			}
			i++;
			s++;
		}
		res += list.get(carry + 1) + " ";
		return res;
	}
}

/*
2,147,483,648
  billion    million    thousand
  
two billion 
one hundred forty seven million
four hundred eighty three thousand 
six hundred forty eight
*/
