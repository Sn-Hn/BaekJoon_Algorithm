package fifth_Training;

import java.util.Scanner;

public class Ouput_Star_10996 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int num = scan.nextInt();
		
		outputStar(num);
	}
	
	public static void outputStar(int n) {
		String star = "*";
		String blankStar = " *";
		
		
		if(n == 1) { System.out.println("*"); return; }
		
		for(int N = 0; N < n; N++) {
			if(n % 2 == 1) {
				System.out.print(star);
				for(int i = 1; i <= n/2; i++) {
					System.out.print(blankStar);
				}
				System.out.println();
				for(int i = 1; i <= n/2; i++) {
					System.out.print(blankStar);
				}
				System.out.println();
			}else {
				System.out.print(star);
				for(int i = 1; i <= n/2-1; i++) {
					System.out.print(blankStar);
				}
				System.out.println();
				for(int i = 1; i <= n/2; i++) {
					System.out.print(blankStar);
				}
				System.out.println();
			}
		}
	}
}
