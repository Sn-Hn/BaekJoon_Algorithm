package thirdStage_for;

import java.util.Scanner;

public class Gugudan {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int A = scan.nextInt();
		
		for(int i = 1; i <= 9; i++) {
			System.out.println(A + " * " + i + " = " + A*i);
		}
		
	}
}
