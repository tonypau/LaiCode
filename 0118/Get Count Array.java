// record 逆序对 during mergesort


/*
cell.val     4     1     3     2
cell.count   0     0     0     0
  
cell.val     1     4     2     3
cell.count   0     1     0     1
  
cell.val     1     2     3     4
cell.count   0     0     1     3

when the cell in the left part moves towards right, we add up count
*/

public class Solution {
  static class Cell {
    int val;
    int count;
    Cell(int val, int count) {
      this.val = val;
      this.count = count;
    }
  }
  public int[] countArray(int[] array) {
    Cell[] cell = new Cell[array.length];
    for (int i = 0; i < array.length; i++) {
      cell[i] = new Cell(array[i], 0);
    }
    Cell[] helper = new Cell[array.length];
    mergeSort(cell, helper, 0, cell.length - 1);
    Map<Integer, Integer> map = new HashMap<>();
    for (Cell c : cell) map.put(c.val, c.count);
    int[] res = new int[array.length];
    for (int i = 0; i < res.length; i++) {
      res[i] = map.get(array[i]);
    }
    return res;
  }
  
  private void mergeSort(Cell[] cell, Cell[] helper, int left, int right) {
    if (left >= right) {
      return;
    }
    int mid = left + (right - left) / 2;
    mergeSort(cell, helper, left, mid);
    mergeSort(cell, helper, mid + 1, right);
    merge(cell, helper, left, mid, mid + 1, right);
  }
  
  private void merge(Cell[] cell, Cell[] helper, int leftL, int leftR, int rightL, int rightR) {
    for (int i = 0; i < cell.length; i++) {
      helper[i] = cell[i];
    }
    int start = leftL;
    while (leftL <= leftR && rightL <= rightR) {
      if (helper[leftL].val <= helper[rightL].val) {
        helper[leftL].count += start - leftL;
        cell[start++] = helper[leftL++];
      } else {
        cell[start++] = helper[rightL++];
      }
    }
    while (leftL <= leftR) {
      helper[leftL].count += start - leftL;
      cell[start++] = helper[leftL++];
    }
  }
}

