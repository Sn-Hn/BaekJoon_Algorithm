package seventh_function;

import java.util.ArrayList;
import java.util.Scanner;

public class HanNum_1065 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		
		
		if(n >= 100) System.out.println(Han(n));
		else System.out.println(n);
	}
	
	public static int Han(int n) {
		int cnt = 99;
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int i = 100; i <= n; i++) {
			int num = i;
			while(num >= 1) {
				list.add(num%10);
				num/=10;
				
			}
			if(list.get(0)-list.get(1) == list.get(1)-list.get(2)) {
				cnt++;
			}
			list.clear();
		}
		if(n == 1000) {
			cnt--;
		}
		
		
		return cnt;
	}
	
}
