package java;

import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class HashMap_Basic {
	/* 수 입력 */
	public HashMap<Integer, Integer> InputNum() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for(int i = 0; i < n; i++) {
			map.put(scan.nextInt(), scan.nextInt());
		}
		
		return map;
	}
	
	/* HashMap */
	public int[] solution() {
		int arr[] = null;
		HashMap<Integer, Integer> map = InputNum();
		System.out.println();
		
		Set<Integer> keys = map.keySet();
		Collection<Integer> values = map.values();
		
		for(int key : keys) {
			System.out.println(key);
		}
		
		/* 람다식 */
		values.forEach(value -> System.out.println(value));
		
		return arr;
	}
}
