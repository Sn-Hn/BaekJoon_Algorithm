package thirdStage_for;

import java.util.Scanner;

public class Add_for {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int A = scan.nextInt();
		
		for(int i = 0; i < A; i++) {
			int B = scan.nextInt();
			int C = scan.nextInt();
			System.out.println(B+C);
		}
	}
}
