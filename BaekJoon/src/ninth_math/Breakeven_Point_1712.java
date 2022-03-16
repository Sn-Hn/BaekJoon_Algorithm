package ninth_math;

import java.util.Scanner;

public class Breakeven_Point_1712 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		int c = scan.nextInt();
		int i = 1;
		
		if(b >= c) {
			i = -1;
		}else {
			i = a/(c-b)+1;
		}
		System.out.println(i);
		
	}
	
}
