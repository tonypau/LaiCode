Assumptions:
- Return what? yes/no? values? index?
- find one solution or all solutions?
- sorted/unsorted
- optimize time or space?
- data size (what if the data cannot fit in memory?)
- duplicate or no duplication

Solution1: unsorted
HashMap: all the numbers processed so far
for each step:
  find whether target-a[i] is in the hashmap
  insert a[i] into the hashmap
tc: O(n) in average, O(n^2) in worst case
sc: O(n)


Solution2: sorted
two pointers in opposite directions


Solution3: unsorted, optimized for space
for (int i = 0; i < n; i++) {
  for (int j = i + 1; j < n; j++) {
    if (a[i] + a[j] == target) {
      return true;
    }
  }
}
return false;

tc: O(n^2)
sc: O(1)


Solution4: unsorted, optimized for space.  
  But need to clarify whether the input can be modified or not
Step1: heapsort --O(nlogn)time, O(1)
Step2: solution2 --O(n) time, O(1)
heap-sort:
  first heapify to a max heap.  O(n) time, O(1) space
  then percolate down each root to sort into a ascending array
