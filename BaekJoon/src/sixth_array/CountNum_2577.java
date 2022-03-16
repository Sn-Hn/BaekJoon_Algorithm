package sixth_array;

import java.util.Scanner;

public class CountNum_2577 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		int c = scan.nextInt();
		int cnt[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		int std = 0;
		int mul = a*b*c;
		
		while(mul > 0) {
			std = mul%10;
			cnt[std]++;
			mul /= 10;
		}
		for(int i : cnt) {
			System.out.println(i);
		}
		
	}
}
