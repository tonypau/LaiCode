/*
class 13: DFS2
Q4.3: Given two copies of all integers from 1 to n: input[2N] = {1,1,2,2,3,3,4,4,5,5,...,n,n}. 
Please determine whether it is possible to shuffle the numbers, such that for each i, there are exactly i numbers between the two i's.
*/

// method 1: check before adding branch
  private List<int[]> DFS(int n) {
    List<int[]> res = new ArrayList<>();
    int[] helper = new int[2 * n];
    for (int i = 0; i < n; i++) {
      helper[i * 2] = i + 1;
      helper[i * 2 + 1] = i + 1;
    }
    Set<Integer> set = new HashSet<>();
    DFS(helper, res, set, 0, 2 * n);
    return res;
  }

  private void DFS(int[] helper, List<int[]> res, Set<Integer> set, int index, int n) {
    if (index == n) {
      res.add(Arrays.copyOf(helper, helper.length));
      return;
    }
    for (int i = index; i < n; i++) {
      if (set.contains(helper[i])) {
        if (!isValid(helper, i)) {
          break;
        } else {
          swap(helper, i, index);
          DFS(helper, res, set, index + 1, n);
          swap(helper, i, index);
        }
      } else {
        set.add(helper[i]);
        swap(helper, i, index);
        DFS(helper, res, set, index + 1, n);
        swap(helper, i, index);
        set.remove(helper[i]);
      }
    }
  }


  private boolean isValid(int[] helper, int i) {
    if (i - helper[i] - 1 >= 0 && helper[i - helper[i] - 1] == helper[i]) {
      return true;
    }
    return false;
  }

  private void swap(int[] nums, int i, int j) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
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
