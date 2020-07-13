package firstStage_InOutput_Calculation;

import java.util.Scanner;

public class HardMultiplication {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int A = scan.nextInt();
		int B = scan.nextInt();
		int b = 0;
		int C = B;
		while(B >= 10) {
			b = B%10;
			B = B/10;
			System.out.println(A*b);
		}
		System.out.println(A*B);
		System.out.println(A*C);
		
	}
}