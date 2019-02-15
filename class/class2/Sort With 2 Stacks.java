package test;

import java.util.Deque;
import java.util.LinkedList;

public class SortWith2Stacks {
	public static void main(String[] args) {
		SortWith2Stacks sortWithStacks = new SortWith2Stacks();
		int[] array = {3,1,2,4};
		Deque<Integer> s1 = new LinkedList<Integer>();
		for (int i : array) {
			s1.offerLast(i);
		}
		sortWithStacks.sort(s1);
		int size = s1.size();
		for (int i = 0; i < size; i++) {
			System.out.println(s1.pollFirst());
		}
	}
	
	public void sort(Deque<Integer> s1) {
		Deque<Integer> s2 = new LinkedList<Integer>();
		int global_min = Integer.MAX_VALUE;
		int global_min_count = 0;
		
		while (!s1.isEmpty()) {
			while (!s1.isEmpty()) {
				if (s1.peekLast() < global_min) {
					global_min = s1.peekLast();
				}
				s2.offerLast(s1.pollLast());
			}
			
			while (!s2.isEmpty() && s2.peekLast() >= global_min) {
			  if (s2.peekLast() != global_min) {
			    s1.offerLast(s2.pollLast());
			  } else {
			    global_min_count++;
			    s2.pollLast();
			  }
			}
			
			for (int i = 0; i < global_min_count; i++) {
				s2.offerLast(global_min);
			}
			global_min = Integer.MAX_VALUE;
			global_min_count = 0;
		}
		int length = s2.size();
		for (int index = 0; index < length; index++) {
			s1.offerFirst(s2.pollLast());
		}
	}
}
