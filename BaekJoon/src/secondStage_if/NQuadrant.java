package secondStage_if;

import java.util.Scanner;

public class NQuadrant {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int A = scan.nextInt();
		int B = scan.nextInt();
		
		if(A>0) {
			if(B>0) System.out.println("1");
			else System.out.println("4");
		}else {
			if(B>0) System.out.println("2");
			else System.out.println("3");
		}
	}
}
