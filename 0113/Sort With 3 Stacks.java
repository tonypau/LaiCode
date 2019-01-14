// O(nlogn)
// silimar with merge sort
public class Solution {
  public void sort(LinkedList<Integer> s1) {
    LinkedList<Integer> s2 = new LinkedList<Integer>();
    LinkedList<Integer> s3 = new LinkedList<Integer>();
    merge(s1, s2, s3, s1.size());
  }
  
  private void merge(LinkedList<Integer> s1, LinkedList<Integer> s2, LinkedList<Integer> s3, int length) {
    if (length <= 1) return;
    int mid1 = length / 2;  // s2 length
    int mid2 = length - length / 2;  // s1 remaining length
    for (int i = 0; i < mid1; i++) {
      s2.offerFirst(s1.pollFirst());
    }
    merge(s2, s3, s1, mid1);
    merge(s1, s3, s2, mid2);
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
    for (int index = 0; index < length; index++) {
      s1.offerFirst(s3.pollFirst());    
    }
  }
}


/*
s1: 25317
s2: 9684
s3: 
*/
