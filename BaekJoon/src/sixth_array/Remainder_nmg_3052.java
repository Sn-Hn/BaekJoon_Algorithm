package sixth_array;

import java.util.HashSet;
import java.util.Scanner;

public class Remainder_nmg_3052 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int arr[] = new int[10];
		int nmg = 0;
		HashSet<Integer> hs = new HashSet<>();
		for(int i = 0; i < 10; i++) {
			arr[i] = scan.nextInt();
		}
		
		for(int i : arr) {
			nmg = i%42;
			hs.add(nmg);
		}
		
		System.out.println(hs.size());
		
	}
}
