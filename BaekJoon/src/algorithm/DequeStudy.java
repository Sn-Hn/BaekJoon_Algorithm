package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class DequeStudy {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Deque<Integer> list = new ArrayDeque<>();
		
		for(int i = 0; i < 10; i++) {
			list.add(i);
		}
		
		System.out.println(list);
		
		list.addFirst(list.pollLast());
		
		System.out.println(list);
		
		list.addLast(list.pollFirst());
		
		System.out.println(list);
		
		
		br.close();
		
	}
}
