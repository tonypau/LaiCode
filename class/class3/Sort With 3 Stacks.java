public class Solution {
  public void sort(LinkedList<Integer> s1) {
    LinkedList<Integer> s2 = new LinkedList<Integer>();
    LinkedList<Integer> s3 = new LinkedList<Integer>();
    mergeSort(s1, s2, s3, s1.size());    
  }
  
  /*
  * s1: first half, 
  * s2: second half,
  * s3: helper stack to store the sorted result of s1 and s2
  * length: length of the sum length of s1 and s2, help move elements from s3 to s1 at last
  */
  private void mergeSort(LinkedList<Integer> s1, LinkedList<Integer> s2, LinkedList<Integer> s3, int length) {
    if (length <= 1) return;
    int mid1 = length / 2;
    int mid2 = length - length / 2;
    for (int i = 0; i < mid1; i++) {
      s2.offerFirst(s1.pollFirst());
    }
    mergeSort(s2, s3, s1, mid1);
    mergeSort(s1, s3, s2, mid2);
    int i = 0;
    int j = 0;
    while (i < mid1 && j < mid2) {
      if (s1.peekFirst() < s2.peekFirst()) {
        s3.offerFirst(s1.pollFirst());
        j++;
      } else {
        s3.offerFirst(s2.pollFirst());
        i++;
      }
    }
    while (i < mid1) {
      s3.offerFirst(s2.pollFirst());
      i++;
    }
    while (j < mid2) {
      s3.offerFirst(s1.pollFirst());
      j++;
    }
    for (int k = 0; k < length; k++) {
      s1.offerFirst(s3.pollFirst());
    }
  }
}
