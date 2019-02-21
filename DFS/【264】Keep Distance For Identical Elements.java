/*
class 13: DFS2
Q4.3: Given two copies of all integers from 1 to n: input[2N] = {1,1,2,2,3,3,4,4,5,5,...,n,n}. 
Please determine whether it is possible to shuffle the numbers, such that for each i, there are exactly i numbers between the two i's.
*/

// method 1: check before adding branch

// 2n levels, every level has n branches
// case1: the first time appears, step into the next level
// case2: the second time appears, check if the last time insertion location is correct
  public List<List<Integer>> findValidPermu(int n) {
		List<List<Integer>> res = new ArrayList<>();
		if(n <= 1) {
			return res;
		}
		Map<Integer, Integer> map = new HashMap<>();
		// initialize the map
		for (int i = 1; i <= n; i++) {
			map.put(i, 0);
		}
		dfs(res, 0, new ArrayList<>(), n, map);
		return res;
	}

	private void dfs(List<List<Integer>> res, int index, List<Integer> temp, int n, Map<Integer, Integer> map) {
		if (temp.size() == 2 * n) {
			res.add(new ArrayList<>(temp));
		}
		for (int i = 1; i <= n; i++) {
			//check the case1 and case2
			if (map.get(i) == 0 || (map.get(i) == 1 && isValid(index, i, temp))) {
				temp.add(i);
				map.put(i, map.get(i) + 1);
				dfs(res, index + 1, temp, n, map);
				temp.remove(temp.size() - 1);
				map.put(i, map.get(i) - 1);
			}
		}
	}

	private boolean isValid(int index, int num, List<Integer> list) {
		if (index - num - 1 < 0 || list.get(index - num - 1) != num) {
			return false;
		}
		return true;
	}
  

// method2: similar with parenthesis inserting. find all available possibility and for-loop
  private List<int[]> DFS(int n) {
    List<int[]> res = new ArrayList<>();
    int[] helper = new int[2 * n];
    DFS(helper, res, n, n);
    return res;
  }    

  private void DFS(int[] helper, List<int[]> res, int cur, int n) {
    if (cur == 0) {
      res.add(Arrays.copyOf(helper, helper.length));
      return;
    }
    List<Integer> index = getAvail(helper, cur);
    for (int i = 0; i < index.size(); i++) {
      helper[index.get(i)] = cur;
      helper[index.get(i) + cur + 1] = cur;
      DFS(helper, res, cur - 1, n);
      helper[index.get(i)] = 0;
      helper[index.get(i) + cur + 1] = 0;
    }
  }

  private List<Integer> getAvail(int[] helper, int cur) {
    List<Integer> res = new ArrayList<>();
    for (int i = 0; i < helper.length; i++) {
      if (helper[i] == 0) {
        if (i + cur + 1 < helper.length && helper[i + cur + 1] == 0) {
          res.add(i);
        }
      }
    }    
    return res;
  }
