package fifthStage_Training;

import java.util.Scanner;

public class Output_Star_2523 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int num = scan.nextInt();
		String star = "*";
		for(int i = 1; i <= num; i++) {
			for(int j = 1; j <= i; j++) {
				System.out.print(star);
			}
			System.out.println();
		}
		
		for(int i = num+1; i <= num*2-1; i++) {
			for(int j = num*2-1; j >= i; j--) {
				System.out.print(star);
			}
			System.out.println();
		}
		
		
	}
}
