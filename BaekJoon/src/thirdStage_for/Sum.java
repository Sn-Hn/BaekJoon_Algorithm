package thirdStage_for;

import java.util.Scanner;

public class Sum {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int A = scan.nextInt();
		int sum = 0;
		
		for(int i = 1; i<=A; i++) {
			sum += i;
		}
		System.out.println(sum);
	}
}
